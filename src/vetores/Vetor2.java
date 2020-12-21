package vetores;

public class Vetor2 {

	public static void main(String[] args) {
		Integer a[] = {100, 100};
		System.out.println(find_total(a));
		
	}
	
	public static Integer find_total(Integer[] my_list) {
		Integer soma = 0;
		for (int i = 0; i < my_list.length; i++) {
			if (i % 2 == 0) {
				soma += my_list[i];
			} else {
				soma -= my_list[i];
			}
		}
		return soma;
	}

}
