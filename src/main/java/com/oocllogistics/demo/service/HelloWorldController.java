package com.oocllogistics.demo.service;

import com.alibaba.fastjson.JSON;


import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by FANAN3 on 10/9/2016.
 */
@Controller
public class HelloWorldController {

    @RequestMapping(value = "/searchCustomer", method = RequestMethod.POST)
    @ResponseBody
    public String helloWorld(@RequestParam String cust,@RequestParam String code) throws ServletException,IOException{

        String line = getData();

        System.out.println("INFO: SearchCondition -- cust: "+cust+"  code:"+code);
        List<CustInfoDTO> infoDTOs = new ArrayList<CustInfoDTO>();
        String jsonResult;
        infoDTOs = JSONArray.parseArray(line, CustInfoDTO.class);

        jsonResult = searchObjects(infoDTOs,cust,code);
        System.out.println("INFO: SearchResult --  "+jsonResult);
        return  jsonResult;
    }

    private String getData() throws IOException {
        String pathName = "D:\\Git Project\\custInfoDemo\\custInfo\\data\\data.json";
        File file = new File(pathName);
        String line = "";
        if(file.isFile() && file.exists() ){
            InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader br = new BufferedReader(read);
            String tempLine = "" ;
            while((tempLine = br.readLine()) != null){
                line += tempLine;
            }
            br.close();
            read.close();
        }
        return line;
    }

    private String searchObjects(List<CustInfoDTO> custDtos,String name,String code){
        List<CustInfoDTO> showCustDtos = new ArrayList<CustInfoDTO>();
        String tempName,tempCode,tempShowDtos,jsonResult = "";
        int all_num = custDtos.size()
                ,show_num = 0;
        for(int i = 0;i < all_num; i ++){
            tempName = custDtos.get(i).getCustName();
            tempCode = custDtos.get(i).getCustCode();
            if(tempName.contains(name)){
                if(tempCode.contains(code)){
                    showCustDtos.add(custDtos.get(i));
                    show_num ++;
                }
            }
        }
        tempShowDtos = JSON.toJSONString(showCustDtos);
        jsonResult = "{\"data\":"+ tempShowDtos + ",\"allNum\":"+all_num+",\"showNum\":"+show_num+"}";
        return jsonResult;
    }

    // for testing..
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("file.encoding"));
        String pathName = "D:\\Git Project\\custInfoDemo\\custInfo\\data\\data.json";
        File file = new File(pathName);
        String line = "";
        if(file.isFile() && file.exists() ){
            InputStreamReader read = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(read);
            String tempLine = "" ;
            while((tempLine = br.readLine()) != null){
                line += tempLine;
            }
            read.close();
        }
        System.out.println(line);
        List<CustInfoDTO> infoDTOs = new ArrayList<CustInfoDTO>();
        infoDTOs = JSONArray.parseArray(line, CustInfoDTO.class);
        int all_num = 5,show_num=3;
        String jsonResult = "{\"data\":"+ JSON.toJSONString(infoDTOs) + ",\"allNum\":"+all_num+",\"showNum\":"+show_num+"}";
        System.out.println(jsonResult);
    }
}
