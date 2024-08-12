package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1000, "mustafa", "redifoğlu"));
        employees.add(new Employee(1001, "hilal", "redifoğlu"));
        employees.add(new Employee(1002, "berkay", "redifoğlu"));
        employees.add(new Employee(1000, "vedat", "redifoğlu"));
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        List<Employee> duplicates = new LinkedList<>();
        for (Employee employee : list) {
            if (Collections.frequency(list, employee) > 1 && !duplicates.contains(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Set<Employee> uniqueSet = new HashSet<>();

        for (Employee employee : list) {
            uniqueSet.add(employee);
        }
        for (Employee employee : uniqueSet) {
            if (employee != null) {

                uniqueMap.put(employee.getId(), employee);
            }

        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
//        List<Employee> result = new ArrayList<>();
//        Set<Employee> set=new HashSet<>();
//        Set<Employee> duplicate=new HashSet<>();
//        for(Employee employee:list){
//            if(employee!=null){
//                if(Collections.frequency(list,employee)==1){
//                    set.add(employee);
//                }else{
//                    duplicate.add(employee);
//                }
//            }
//        }
//        result.addAll(set);
//        return result;
        List<Employee> duplicates=findDuplicates(list);
        Map<Integer,Employee> uniques=findUniques(list);
        List<Employee> uniqueList=new ArrayList<>(uniques.values());
        uniqueList.removeAll(duplicates);
        return uniqueList;
    }
}