import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void imprime_matriz(int[][] ma) {
        
        for(int i=0;i<ma.length;i++){
            for(int j=0;j<ma[i].length;j++){
                System.out.print(ma[i][j]+" ");
            }
            System.out.println("");
        }
        
        
    }
    
    static int[] ordenaArreglo(int arreglo[])
    {
 
        int k=0;
        for(int i=1;i<arreglo.length;i++)
        {
            for(int j=0;j<arreglo.length-i;j++)
            {
                if(arreglo[j]>arreglo[j+1]){
                    k=arreglo[j+1]; 
                    arreglo[j+1]=arreglo[j]; 
                    arreglo[j]=k;
                }
            }
        }
        return arreglo;     
     
    }
    
    public static void imprime_medidas(int[][] ma){
        /*for(int i=0;i<ma.length;i++){
            System.out.println("valor: "+ma[i][3]+" ");
        }*/
        
        //MEAN
        double sum = 0;
        for (int i = 0; i < ma.length; i++) {
            sum += ma[i][3];
        }
        System.out.println("Mean: " + (sum / ma.length) );
        
        //MEDIAN
        int[] ma_ordenado = new int[ma.length];
        for (int i = 0; i < ma.length; i++) { //ordena la matriz por orden ascendente
            ma_ordenado[i] = ma[i][3];
        }
        ma_ordenado = ordenaArreglo(ma_ordenado);
        
        int middle = ma_ordenado.length/2;
        if (ma_ordenado.length%2 == 1) {
            System.out.println("Median: "+ (ma_ordenado[middle]));
        } else if (ma.length%2 == 0) {
            System.out.println("Median: "+((ma_ordenado[middle-1] + ma_ordenado[middle]) / 2)) ;
        }
        
        //MODE
        int maxValue=0, maxCount=0;
        for (int i = 0; i < ma.length; ++i) {
            int count = 0;
            for (int j = 0; j < ma.length; ++j) {
                if (ma[j][3] == ma[i][3]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = ma[i][3];
            }
        }
        System.out.println("Mode: "+ maxValue);
        
        //STANDARD DEVIATION
        double powerSum1 = 0;
        double powerSum2 = 0;
        double stdev = 0;

        for (int i=0; i<ma.length;i++) {
            powerSum1 += ma[i][3];
            powerSum2 += Math.pow(ma[i][3], 2);
            stdev = Math.sqrt(i*powerSum2 - Math.pow(powerSum1, 2))/i;
            //System.out.println(total[i]); 
        }
        System.out.println("Standard deviation: "+stdev);
    }
    
    public static double Correlation(int[] xs, int[] ys) {
        
        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int n = xs.length;

        for(int i = 0; i < n; ++i) {
          double x = xs[i];
          double y = ys[i];

          sx += x;
          sy += y;
          sxx += x * x;
          syy += y * y;
          sxy += x * y;
        }

        // covariation
        double cov = sxy / n - sx * sy / n / n;
        // standard error of x
        double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
        // standard error of y
        double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);

        // correlation is just a normalized covariation
        return cov / sigmax / sigmay;
      }


    private static final String archivo = "dataset.txt";


    public static void main(String[] args) {
            
        BufferedReader br = null;
        BufferedReader br2 = null;
	FileReader fr = null;
        FileReader fr2 = null;
	int[][] nums = null;
	int tamcol = 0;
	int tamfil = 0;

	try {
		fr = new FileReader(archivo);
		br = new BufferedReader(fr);

		String linea;

		br = new BufferedReader(new FileReader(archivo));

		//toma tamaño dataset
		while ((linea = br.readLine()) != null) {
			//System.out.println(linea);
			String[] valores = linea.trim().split("\\s+");
			tamcol = valores.length;
			tamfil++;
			
		}
		
		nums = new int[tamfil][tamcol];
		//System.out.println("new int["+tamfil+"]["+tamcol+"]");
		fr2 = new FileReader(archivo);
		br2 = new BufferedReader(fr2);
		
		//mete dataset en matriz
                int row = 0;
		while ((linea = br2.readLine()) != null) {
			String[] valores = linea.trim().split("\\s+");
			for (int col = 0; col < tamcol; col++) {
                            nums[row][col] = Integer.parseInt(valores[col]);
                        }
                        row++;
		}
		
                System.out.println("a. Get the dataset available here");
                System.out.println("----------------------------------");
		imprime_matriz(nums);
		
                System.out.println("");
		System.out.println("b. Print out the mean, mode, median and standard deviation for values in column 4");
                System.out.println("----------------------------------");
		imprime_medidas(nums);
		
		System.out.println("");
		System.out.println("c. Measure and inform about the correlation between column 1 and 3");
                System.out.println("----------------------------------");
                int[] sx = new int[tamfil];
                int[] sy = new int[tamfil];
                for(int i=0;i<tamfil;i++){
                    sx[i]=nums[i][0];
                    sy[i]=nums[i][2];
                }
		System.out.println("Correlation coefficient: "+Correlation(sx,sy));

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();
                        if (br2 != null)
				br.close();

			if (fr2 != null)
				fr.close();
		} catch (IOException ex) {

			ex.printStackTrace();

		}

	}

    }

}

