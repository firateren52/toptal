package com.eren.testdome;

//https://www.testdome.com/questions/java/user-input/11995?visibility=1&skillId=4&orderBy=Difficulty
public class UserInput {
    
    public static class TextInput {
        private StringBuffer value = new StringBuffer();

        public void add(char c) {
            value.append(c);
        }

        StringBuffer getRawValue() {
            return value;
        }

        public String getValue() {
            return value.toString();
        }
    }

    public static class NumericInput extends com.eren.testdome.UserInput.TextInput {
        @Override
        public void add(char c) {
            if(Character.isDigit(c)) {
                getRawValue().append(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new TextInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}