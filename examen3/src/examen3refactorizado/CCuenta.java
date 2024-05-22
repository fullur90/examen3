package examen3refactorizado;
/**
 * @author oscar cos alvarez
 * fecha 22-05-2024
 * Código de una cuenta bancaria*/
public class CCuenta {
    // Propiedades de la Clase Cuenta
    public double dSaldo;
    public String nombre;

    public static void main(String[] args) {

        operativa_cuenta();
    }

	private static void operativa_cuenta() {
		CCuenta cuenta1 = new CCuenta();

        System.out.println("Saldo Incial: " + cuenta1.dSaldo + " euros");

        cuenta1.ingresar(-100);
        System.out.println("Saldo Incial: " + cuenta1.dSaldo + " euros");
        cuenta1.ingresar(100);
        System.out.println("Saldo tras ingreso: " + cuenta1.dSaldo + " euros");
        cuenta1.ingresar(2000);
        System.out.println("Saldo tras ingreso: " + cuenta1.dSaldo + " euros");

        cuenta1.ingresar(300);
        System.out.println("Saldo tras ingreso: " + cuenta1.dSaldo + " euros");
        cuenta1.retirar(50);
        System.out.println("Saldo tras retirada: " + cuenta1.dSaldo + " euros");
	}

    /* Metodo para ingresar cantidades en la cuenta. Modifica el saldo. */
    /**
     * Saldo
     * @return
     */
	public double getdSaldo() {
		return dSaldo;
	}

	public void setdSaldo(double dSaldo) {
		this.dSaldo = dSaldo;
	}
/**
 * Nombre del usuario
 * @return
 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
/**
 * Ingresos de dinero. Como afecta en el saldo el ingreso de dinero
 * @param cantidad
 * @return
 */
	public int ingresar(double cantidad) {
        int iCodErr =0;

        if (cantidad < 0) { 
          if (cantidad > 3000) {
            System.out.println("No se puede ingresar una cantidad negativa ni superior a 3000€ (sin ser notificada con formulario)");
            iCodErr = 1;
          }
        } else if (cantidad == 3000) {
            System.out.println("Le recordamos que estamos obligados a notificar a Hacienda dicho ingreso (superior o igual a 3000€)");
            dSaldo = dSaldo + cantidad;
            iCodErr = 2;
        } else {
            dSaldo = dSaldo + cantidad;
            iCodErr = 0;
        }

        return iCodErr;
    }

    /*
     * Comentario para el nuevo commit
     * Metodo para retirar cantidades en la cuenta. Modifica el saldo.
     */
        /**
         * Retirada de dinero. Como afecta en el saldo la retirada.
         * @param cantidad
         */
    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No se puede retirar una cantidad negativa");
        } else if (dSaldo < cantidad) {
            System.out.println("No  hay suficiente saldo");
        } else {
            dSaldo = dSaldo - cantidad;
            System.out.println("Le quedan " + dSaldo + " en cuenta");
        }
    }
}
