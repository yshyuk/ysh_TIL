import java.awt.List;
import java.util.ArrayList;

public class NewIDMaker {
	
	
	
	/*
	 * 	1�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
		2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
		3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
		4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
		5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
		6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
		     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
		7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.
	 */
    public String solution(String new_id) {
        String answer = "";

        //1 �ܰ�
        String temp = new_id.toLowerCase();
        
        //2 �ܰ�
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        //3 �ܰ�
        temp = temp.replaceAll("[.]{2,}",".");
        //4 �ܰ�
        temp = temp.replaceAll("^[.]|[.]$","");

        //5 �ܰ�
        if(temp.equals(""))
        	temp+="a";
        
        //6 �ܰ�
        if(temp.length()>15) {
        	temp = temp.substring(0,15);
        	temp = temp.replaceAll("^[.]|[.]$","");
        }
        
        //7 �ܰ�
        if(temp.length()<3) {
        	while(temp.length()<3) {
        		temp = temp+temp.charAt(temp.length()-1);
        	}
        	
        }
        answer = temp;
        
        return answer;

    }
    
    
    public static void main(String[] args) {
    	String id1 = "=.=";
    	String id2 = "z-+.^.";
    	String id3 = "...!@BaT#*..y.abcdefghijklm";
    	
    	NewIDMaker nid = new NewIDMaker();
    	System.out.println("id 1 "+id1+" => "+nid.solution(id1));
    	System.out.println("id 2 "+id2+" => "+nid.solution(id2));
    	System.out.println("id 3 "+id3+" => "+nid.solution(id3));
    }
    
    
    //Ǯ�� 1
    public String solution2(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
	//��ó : https://programmers.co.kr/learn/courses/30/lessons/72410
}
