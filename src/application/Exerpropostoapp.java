package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Exfix;

public class Exerpropostoapp {

	public static void main(String[] args) {
		/*
		 * Fazer um programa para ler um n�mero inteiro N e depois os dados (id, nome e
		 * salario) de N funcion�rios. N�o deve haver repeti��o de id. Em seguida,
		 * efetuar o aumento de X por cento no sal�rio de um determinado funcion�rio.
		 * Para isso, o programa deve ler um id e o valor X. Se o id informado n�o
		 * existir, mostrar uma mensagem e abortar a opera��o. Ao final, mostrar a
		 * listagem atualizada dos funcion�rios, conforme exemplos. Lembre-se de aplicar
		 * a t�cnica de encapsulamento para n�o permitir que o sal�rio possa ser mudado
		 * livremente. Um sal�rio s� pode ser aumentado com base em uma opera��o de
		 * aumento por porcentagem dada. (exemplo na pr�xima p�gina)
		 */
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Exfix> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		Integer n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Emplyoee #" + (i + 1) + ": ");

			System.out.print("Id: ");
			Integer id = sc.nextInt();

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Exfix emp = new Exfix(id, name, salary);
			list.add(emp);
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();// para ver se esse id existe, vamos fazer uma fun��o auxiliar abaixo.
		Integer pos = position(list, idsalary);
		if (pos == null) {
			System.out.println("This id does not exist");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			list.get(pos).increaseSalary(percentage);
			System.out.println();
		}
		System.out.println("List of employees: ");
		for (Exfix emp : list) {
			System.out.println(emp);
		}
		sc.close();

	}

	// fun��o auxiliar para encontrar o id repetido
	public static Integer position(List<Exfix> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
}
