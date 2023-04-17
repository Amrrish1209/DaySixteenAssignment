package com.bridgelabz.algorithmprogram;

import java.util.*;

public class Permutations {

	public static ArrayList<String> iterativePermutations(String str) {
		ArrayList<String> result = new ArrayList<>();
		result.add(String.valueOf(str.charAt(0))); // Add the first character
		for (int i = 1; i < str.length(); i++) {
			char ch = str.charAt(i);
			int size = result.size();
			for (int j = size - 1; j >= 0; j--) {
				String perm = result.remove(j);
				for (int k = 0; k <= perm.length(); k++) {
					result.add(perm.substring(0, k) + ch + perm.substring(k));
				}
			}
		}
		return result;
	}

	public static ArrayList<String> recursivePermutations(String str) {
		ArrayList<String> result = new ArrayList<>();
		if (str.length() == 0) {
			result.add("");
			return result;
		}
		char ch = str.charAt(0);
		String substr = str.substring(1);
		ArrayList<String> perms = recursivePermutations(substr);
		for (String perm : perms) {
			for (int i = 0; i <= perm.length(); i++) {
				result.add(perm.substring(0, i) + ch + perm.substring(i));
			}
		}
		return result;
	}

	public static boolean isEqual(ArrayList<String> list1, ArrayList<String> list2) {
		if (list1.size() != list2.size()) {
			return false;
		}
		Collections.sort(list1);
		Collections.sort(list2);
		for (int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "abc";
		ArrayList<String> iterativePerms = iterativePermutations(str);
		ArrayList<String> recursivePerms = recursivePermutations(str);
		if (isEqual(iterativePerms, recursivePerms)) {
			System.out.println("The arrays returned by the two string functions are equal.");
		} else {
			System.out.println("The arrays returned by the two string functions are not equal.");
		}
	}
}
