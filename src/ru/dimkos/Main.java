package ru.dimkos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out
				.println("Commands: help, put, get, remove, size, clear, keys, elements, exit");
		String[] command;
		MyDictionary<String, String> dictionary = new MyDictionary<String, String>();
		String str = null;

		BufferedReader bReader = new BufferedReader(new InputStreamReader(
				System.in));

		while (true) {
			str = bReader.readLine();
			command = str.split(" ");

			if (command[0].equals("put")) {
				System.out.println("Value: "
						+ dictionary.put(command[1], command[2]));
			} else if (command[0].equals("get")) {
				System.out.println("Value: " + dictionary.get(command[1]));
			} else if (command[0].equals("remove")) {
				System.out.println("Removed: " + dictionary.remove(command[1]));
			} else if (command[0].equals("size")) {
				System.out.println("Size: " + dictionary.size());
			} else if (command[0].equals("clear")) {
				dictionary.clear();
				System.out.println("Size: " + dictionary.size());
			} else if (command[0].equals("keys")) {
				System.out.println("Elements: " + dictionary.keys().toString());
			} else if (command[0].equals("elements")) {
				System.out.println("Elements: "
						+ dictionary.elements().toString());
			} else if (command[0].equals("help")) {
				help();
			} else if (command[0].equals("exit")) {
				break;
			}
		}
	}

	private static void help() {
		System.out.println("help             - show help");
		System.out.println("put    key value - return old value");
		System.out.println("get    key       - return value");
		System.out.println("remove key       - return value");
		System.out.println("size             - return size");
		System.out.println("clear            - clear dictionary");
		System.out.println("keys             - return keys");
		System.out.println("elements         - return elements");
		System.out.println("exit             - close program");
	}

}
