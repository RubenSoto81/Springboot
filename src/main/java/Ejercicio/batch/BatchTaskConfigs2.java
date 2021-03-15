package Ejercicio.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.batch.item.database.JpaPagingItemReader;
import javax.persistence.EntityManagerFactory;
import Ejercicio.entity.Clientes;


@Configuration
@EnableBatchProcessing
public class BatchTaskConfigs2 {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Bean
  public ItemReader<Clientes> reader2() throws Exception {
    String jpqlQuery = "select c from Clientes c";
    System.out.println("Task > Getting reader for Clientes");
    JpaPagingItemReader<Clientes> reader = new JpaPagingItemReader<>();

    reader.setQueryString(jpqlQuery);
    reader.setEntityManagerFactory(entityManagerFactory);
    reader.setPageSize(3);
    reader.afterPropertiesSet();
    reader.setSaveState(true);

    return reader;
  }

 /* @Bean
  public InformeProcessor processor2() {
    return new InformeProcessor();
  }*/

  @Bean
  ItemWriter<Clientes> xmlWriter2() {
    StaxEventItemWriter<Clientes> xmlFileWriter = new StaxEventItemWriter<>();
    xmlFileWriter.setResource(new FileSystemResource(".//src//main//resources//static//tmp//cliente-sin-procesar.xml"));
    xmlFileWriter.setRootTagName("clientes");
    Jaxb2Marshaller receiptMarshaller = new Jaxb2Marshaller();
    receiptMarshaller.setClassesToBeBound(Clientes.class);
    xmlFileWriter.setMarshaller(receiptMarshaller);
    return xmlFileWriter;
  }

  @Bean
  public Job importUserJob2(TaskCompletionHandler listener) throws Exception {
    return jobBuilderFactory
            .get("importUserJob2")
            .incrementer(new RunIdIncrementer())
       //     .listener(listener)
            .flow(step2())
            .end()
            .build();
  }

  @Bean
  public Step step2() throws Exception {
    return stepBuilderFactory
            .get("step2")
            .<Clientes, Clientes>chunk(10)
            .reader(reader2())
         //   .processor(processor2())
            .writer(xmlWriter2())
            .build();
  }
}
