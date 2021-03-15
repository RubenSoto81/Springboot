package Ejercicio.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.batch.item.database.JpaPagingItemReader;
import javax.persistence.EntityManagerFactory;
import Ejercicio.entity.Informes;
import Ejercicio.entity.BatchInforme;


@Configuration
@EnableBatchProcessing
public class BatchTaskConfigs {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Bean
  public ItemReader<Informes> reader() throws Exception {
    String jpqlQuery = "select c from Informes c";
    System.out.println("Task > Getting reader for informes");
    JpaPagingItemReader<Informes> reader = new JpaPagingItemReader<>();

    reader.setQueryString(jpqlQuery);
    reader.setEntityManagerFactory(entityManagerFactory);
    reader.setPageSize(3);
    reader.afterPropertiesSet();
    reader.setSaveState(true);

    return reader;
  }

  @Bean
  public InformeProcessor processor() {
    return new InformeProcessor();
  }

  @Bean
  public ItemWriter<BatchInforme> writer() {
    FlatFileItemWriter<BatchInforme> writer = new FlatFileItemWriter<>();
    DelimitedLineAggregator<BatchInforme> lineAggregator = new DelimitedLineAggregator<>();
    BeanWrapperFieldExtractor<BatchInforme> extractor = new BeanWrapperFieldExtractor<>();

    System.out.println("Task> Getting writer ");
    extractor.setNames(new String[]{"name", "dni", "account", "total"});

    lineAggregator.setDelimiter(";");
    lineAggregator.setFieldExtractor(extractor);

    writer.setResource(new FileSystemResource(".//src//main//resources//static//tmp//tmp/alumno-data.csv"));
    // writer.setResource(new ClassPathResource("bank-data.csv")); // Other option
    writer.setLineAggregator(lineAggregator);

    return writer;
  }

  @Bean
  ItemWriter<BatchInforme> xmlWriter() {
    StaxEventItemWriter<BatchInforme> xmlFileWriter = new StaxEventItemWriter<>();
    xmlFileWriter.setResource(new FileSystemResource(".//src//main//resources//static//tmp//informes-data.xml"));
    // xmlFileWriter.setResource( new ClassPathResource("bank-data.xml"));
    xmlFileWriter.setRootTagName("informes");

    Jaxb2Marshaller receiptMarshaller = new Jaxb2Marshaller();
    receiptMarshaller.setClassesToBeBound(BatchInforme.class);
    xmlFileWriter.setMarshaller(receiptMarshaller);

    return xmlFileWriter;
  }

  @Bean
  public Job importUserJob(TaskCompletionHandler listener) throws Exception {
    return jobBuilderFactory
            .get("importUserJob")
            .incrementer(new RunIdIncrementer())
       //     .listener(listener)
            .flow(step1())
            .end()
            .build();
  }

  @Bean
  public Step step1() throws Exception {
    return stepBuilderFactory
            .get("step1")
            .<Informes, BatchInforme>chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(xmlWriter())
            .build();
  }
}
