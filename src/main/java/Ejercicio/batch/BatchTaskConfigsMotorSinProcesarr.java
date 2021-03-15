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
import Ejercicio.entity.Motor;


@Configuration
@EnableBatchProcessing
public class BatchTaskConfigsMotorSinProcesarr {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Bean
  public ItemReader<Motor> reader3() throws Exception {
    String jpqlQuery = "select c from Motor c";
    System.out.println("Task > Getting reader for Motores");
    JpaPagingItemReader<Motor> reader = new JpaPagingItemReader<>();

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
  ItemWriter<Motor> xmlWriter3() {
    StaxEventItemWriter<Motor> xmlFileWriter = new StaxEventItemWriter<>();
    xmlFileWriter.setResource(new FileSystemResource(".//src//main//resources//static//tmp//motor-sin-procesar.xml"));
    xmlFileWriter.setRootTagName("Motor");
    Jaxb2Marshaller receiptMarshaller = new Jaxb2Marshaller();
    receiptMarshaller.setClassesToBeBound(Motor.class);
    xmlFileWriter.setMarshaller(receiptMarshaller);
    return xmlFileWriter;
  }

  @Bean
  public Job importUserJob3(TaskCompletionHandler listener) throws Exception {
    return jobBuilderFactory
            .get("importUserJob2")
            .incrementer(new RunIdIncrementer())
       //     .listener(listener)
            .flow(step3())
            .end()
            .build();
  }

  @Bean
  public Step step3() throws Exception {
    return stepBuilderFactory
            .get("step2")
            .<Motor, Motor>chunk(10)
            .reader(reader3())
         //   .processor(processor2())
            .writer(xmlWriter3())
            .build();
  }
}
