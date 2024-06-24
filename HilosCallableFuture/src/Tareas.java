import java.util.concurrent.Callable;

public class Tareas implements Callable<Integer> {

	private final int id;
	/*private final int operation;
	
	
	public Tareas(int id, int operation) {
		super();
		this.id = id;
		this.operation = operation;
	}*/

	
	public Tareas(int id) {
		super();
		this.id = id;
	}


	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(" Hilo " + Thread.currentThread().getName() + " haciendo tarea " +id);
		
		
		  /*switch (operation) {
          case 0:
              return id * 2;
          case 1:
              return id * 100 ;
          case 2:
              return 100009;
          default:
              return 0;
      }*/
		return id * 2;
	}
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	


