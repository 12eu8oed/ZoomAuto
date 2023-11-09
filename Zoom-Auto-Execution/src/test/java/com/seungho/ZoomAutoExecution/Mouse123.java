package com.seungho.ZoomAutoExecution;

import java.awt.MouseInfo;
import java.awt.PointerInfo; 
 
public class Mouse123{ //마우스 좌표 어디에 나오는지 표시
 
public static void main(String[] args) {
             PointerInfo pt = MouseInfo.getPointerInfo();
             while(true) {
                    pt = MouseInfo.getPointerInfo();
                    
                    System.out.println(pt.getLocation()); // x,y 
                    System.out.println(pt.getLocation().x);// x 좌표
                    System.out.println(pt.getLocation().y); // y 좌표
             }
       }
}