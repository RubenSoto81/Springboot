package Ejercicio.batch;

import org.springframework.batch.item.ItemProcessor;
import Ejercicio.entity.BatchInforme;
import Ejercicio.entity.Informes;

public class InformeProcessor implements ItemProcessor<Informes, BatchInforme> {

  @Override
  public BatchInforme process(Informes informe) throws Exception {
   /* Double total = 0d;
    int contador = 0;
    double notaMedia;

    for (Examen examen : alumno.getExamenes()) {
      total += examen.getNota();
      contador++;
    }
    
    notaMedia = total/contador;

    EvaluacionAlumno evaluacionAlumno = new EvaluacionAlumno(alumno, notaMedia);*/
   BatchInforme informeProcesadoBatch = new BatchInforme(informe);
   
    System.out.println("Processor > Informe evaludado: " + informeProcesadoBatch);

    return informeProcesadoBatch;
  }
}
