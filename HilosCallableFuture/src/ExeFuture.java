import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExeFuture {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		  // Crear una lista de tareas concurrentes
        Callable<?>[] tasks = new Callable<?>[50];
        for (int i = 0; i < 50; i++) {
            //tasks[i] = new Tareas(i, i%2);
        	tasks[i] = new Tareas(i);
        }

        // Ejecutar las tareas concurrentes
        Future<?>[] futures = new Future[50];
        for (int i = 0; i < 50; i++) {
            futures[i] = executor.submit(tasks[i]);
        }
/*
        // Obtener los resultados
        for (int i = 0; i < 50; i++) {
            try {
				System.out.println("Entrega Task " + i + ": " + futures[i].get() + " hilo " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        El resultado siempre se devuelve en el hilo principal (main) porque estás llamando al método get() en el bucle for que recorre los Future objetos. El método get() es un método de bloqueo, lo que significa que el hilo que lo llama se bloquea hasta que la tarea correspondiente al Future se complete y devuelva un resultado.
        Cuando llamas a futures[i].get(), el hilo principal se bloquea esperando a que la tarea i se complete. Una vez que la tarea se completa, el resultado se devuelve al hilo principal.
        */
        
        for (Future<?> future : futures) {
            try {
                System.out.println("Resultado: " + future.get() + " hilo " + Thread.currentThread().getName());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        

        // Cerrar el pool de threads
        executor.shutdown();
        System.out.println(" *** Despues de shutdown de executor " );
		
	}

}





