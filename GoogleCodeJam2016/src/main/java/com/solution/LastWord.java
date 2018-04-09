package com.solution;

import java.io.*;
import java.util.StringTokenizer;


public class LastWord {
    private static InputReader in;
    private static PrintWriter out;


    public static void main(String [] args){
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
        int numOfTestCases = in.nextInt();
        for(int i=1;i<=numOfTestCases;i++){
            String input = in.next();
            out.println(getOutputString(i) + getLastWord(input));
            out.flush();
        }
        out.close();
        System.exit(0);
    }

    public static String getOutputString(int testCaseNum){
        return String.format("Case #%s: ",testCaseNum);
    }


    public static String getLastWord(String input){
    StringBuilder result = new StringBuilder();
    if(input.length() <=1)
        return input;

    result.append(input.charAt(0));
    char start=input.charAt(0);
    char [] str = input.toCharArray();

    for(int i=1;i<input.length();i++){
        if(str[i] >= start){
            result.insert(0,str[i]);
            start = str[i];
        }
        else {
            result.append(str[i]);
        }
    }
        return result.toString();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}

