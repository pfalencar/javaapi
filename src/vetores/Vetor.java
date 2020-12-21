package vetores;

public class Vetor {

	public static void main(String[] args) {
		//int a[]= new int[5];
		Integer a[] = {1, 2, 3, 4, 5};
		System.out.println(find_total(a));
		
	}
	
	public static Integer find_total(Integer[] my_numbers) {
		Integer soma = 0;
		for (int i = 0; i < my_numbers.length; i++) {
			if (my_numbers[i] == 5) {
				soma += 5;
			} else if (my_numbers[i] % 2 == 0) {
				soma += 1;
			} else {
				soma += 3;
			}
		}
		return soma;
	}

}
