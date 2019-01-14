package com.eren.commencis;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public static List<String> checkIPs(List<String> ip_array) {
        // Write your code here
        String hex = "01234567890abcdef";
        List<String> results = new ArrayList<String>();
        String result = "Neither";
        for(String ip : ip_array) {
            if(result.contains(".")) {
                boolean flag4 = true;
                String[] ipNum = ip.split(".");
                if(ipNum.length == 4) {
                    for (int i = 0; i < ipNum.length; i++) {
                        try {
                            int a = Integer.parseInt(ipNum[i]);
                            if(a < 255) {
                                flag4 = false;
                            }
                        } catch (Exception ex) {
                            flag4 = false;
                        }
                    }
                    if (flag4)
                        result = "IPv4";
                }
            } else if(result.contains(":")) {
                boolean flag6 = true;
                String[] ipNum = ip.split(":");
                for(int i = 0; i < ipNum.length; i ++) {
                    try {
                        Integer.parseInt(ipNum[i]);
                    } catch(Exception ex) {
                        flag6 = false;
                    }
                }
                if(flag6)
                    result = "IPv6";
            }

            results.add(result);
        }

        return results;
    }
    // Driver Method
    public static void main(String[] args)
    {

    }
}
