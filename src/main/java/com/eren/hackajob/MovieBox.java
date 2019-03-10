package com.eren.hackajob;

import java.util.ArrayList;
import java.util.List;

public class MovieBox {

	public static void main(String[] args) {
		int[] output = {4,4,5};
		System.out.println(run(5,output.length,output));
	}

	public static String run(int n, int m, int[] movies) {
		/*
		* Some work here; return type and arguments should be according to the problem's requirements
		*/
		List<Integer> stackMovies = new ArrayList<>();
		List<Integer> nextMovies = new ArrayList<>();
		for(int i = 1;i <= n;i ++) {
			stackMovies.add(i);
			nextMovies.add(i - 1);
		}
		List<Integer> movies_array = new ArrayList<>();
		for (int j = 0; j < m; j++) {
			int movieIndex = stackMovies.indexOf(movies[j]);
			int nextMovie = nextMovies.get(movieIndex);
			int next = nextMovies.get(movieIndex);
			int k = 0;
			while(next > 0) {
				next = nextMovies.get(stackMovies.indexOf(next));
				k++;
			}
			movies_array.add(k);
			nextMovies.set(movieIndex, 0);
      		if (nextMovies.indexOf(movies[j]) > 0) {
        		nextMovies.set(nextMovies.indexOf(movies[j]), nextMovie);
			}
			nextMovies.set(0, movies[j]);
		}
		return movies_array.toString();
	}
}