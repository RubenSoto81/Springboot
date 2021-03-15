package Ejercicio.batch;

import javax.transaction.Transactional;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;


@Component
public class TaskCompletionHandler extends JobExecutionListenerSupport {
  /*
   * @Autowired private ExamenRepository examenRepository;
   */

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      // int processed = examenRepository.markProcessed();
      System.out.println("Task completed. Exámenes procesados:  " /* + processed */);
    }
  }
}
