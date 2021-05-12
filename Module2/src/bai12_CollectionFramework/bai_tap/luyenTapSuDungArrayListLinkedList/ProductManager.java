package bai12_CollectionFramework.bai_tap.luyenTapSuDungArrayListLinkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManager extends Product {
    static int id=0;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(id++,900,"Apple"));
        productList.add(new Product(id++,300,"Orange"));
        productList.add(new Product(id++,400,"Banana"));
        int inPut;
        int index= -1;
        do {
            showMenu();
            inPut=scanner.nextInt();
            scanner.skip("\\R");
            switch(inPut){
                case 1:
               Product product1= new Product();
               product1.inPut();
               productList.add(product1);
               break;
                case 2:
                    for (Product item : productList){
                        System.out.println(item);
                    }
                    break;
                case 3:
                    System.out.println("Nhập id cần sửa: ");
                   int enter=scanner.nextInt();
                    scanner.skip("\\R");
                    for(int i=0;i<productList.size();i++){
                        if(enter==productList.get(i).getId()){
                            int editPrice=Integer.parseInt(scanner.nextLine());
                            String editName= scanner.nextLine();
                            productList.get(i).setPrice(editPrice);
                            productList.get(i).setName(editName);
                        }
                   }
                   break;
                case 4:
                    System.out.println("Nhập id cần xóa: ");
                    int enter1=scanner.nextInt();
                    for (int i=0;i<productList.size();i++){
                        if (enter1 == productList.get(i).getId()){
                            productList.remove(productList.get(i));
                        }
                    }
                        break;
                case 5:
                    System.out.println("Nhập tên sản phẩm cần tìm: ");
                    String enter2=scanner.nextLine();
                    for (int i=0;i<productList.size();i++){
                        if(enter2.equals(productList.get(i).getName())){
                            System.out.println(productList.get(i).toString());
                        }
                    }
                    break;
                case 6:
                    productList.sort(Comparator.comparing(Product::getPrice));
                    break;
                case 7:
                    productList.sort(Comparator.comparing(Product::getPrice).reversed());
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Bạn nhập sai rồi, vui lòng nhập lại");
            }
        }while (inPut!=8);
        }
    }

