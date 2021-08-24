import java.awt.List;
import java.util.ArrayList;

public class NewIDMaker {
	
	
	
	/*
	 * 	1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
		2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
		3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
		     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
	 */
    public String solution(String new_id) {
        String answer = "";

        //1 단계
        String temp = new_id.toLowerCase();
        
        //2 단계
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        //3 단계
        temp = temp.replaceAll("[.]{2,}",".");
        //4 단계
        temp = temp.replaceAll("^[.]|[.]$","");

        //5 단계
        if(temp.equals(""))
        	temp+="a";
        
        //6 단계
        if(temp.length()>15) {
        	temp = temp.substring(0,15);
        	temp = temp.replaceAll("^[.]|[.]$","");
        }
        
        //7 단계
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
    
    
    //풀이 1
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
	//출처 : https://programmers.co.kr/learn/courses/30/lessons/72410
}
