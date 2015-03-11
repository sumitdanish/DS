/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoldmanSachs;

import java.util.HashMap;
import java.util.Map;

/**
 * goldman-sachs-interview-questions
    0
    of 0 votes
    18
    Answers

    in one string array{'Good',''word','good','woRd'...}

    how can i print like Good--2
    Word-2 times appeared in the array.even Good and good are different in case sensitive.
 * @author SU915198
 */
public class StringWordCount {
    
    public static void main(String[] args){
        try{
            String[] word = {"Good","word","good","woRd"};
            new StringWordCount().countWOrd(word);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
    }
    public void countWOrd(String[] str){
            try{
                HashMap<String,Integer> map = new HashMap<>();
                for(int i = 0;i<str.length;i++){
                    int ch = 0;
                    StringBuilder sb = new StringBuilder();
                    int count = 1;
                    for(int j = 0;j<str[i].length();j++){
                        ch = str[i].charAt(j);
                        if(ch >=65 && ch<=90){
                            ch = ch+32;
                        }
                        sb = sb.append(ch);
                    }
                    if(map.containsKey(sb.toString())){
                        count++;
                    }
                    map.put(sb.toString(), count);
                }
                for(Map.Entry m : map.entrySet()){
                    System.out.println(m.getKey()+" > "+m.getValue());
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
}
