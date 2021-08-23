StringBuilder
===
String 문자열을 여러 개 합칠 때 사용하는 클래스
---

String 객체가 String 객체를 더하는 행위는 메모리 할당과 메모리 해제를 발생시켜 성능적으로 좋지 않다.

그런 이유로 String 객체 여러개를 더 할 때에는 StringBuilder를 사용한다. 

StringBuilder는 기존의 데이터에 더하는 방식을 사용하여 속도가 빠르며 상대적으로 부하가 적다.

```
StringBuilder sb = new StringBuilder();
sb.append("ABC");
sb.append("ZXC");
String sentence = sb.toString() // "ABCZXC"
```

**[String 클래스와 사용 시 참고할 만한 메소드]**

<br>

|Method|설명|
|----------|---------|
|charAt()|특정 인덱스 위치의 문자 반환|
|indexOf() / lastIndexOf()|문자열 검색해서 위치 반환|
|length()|문자열 길이 반환|
|replace()|검색된 문자열 교체|
|substring()|특정 인덱스 범위 내 문자열을 복사해서 새로 생성된 인스턴스 반환|
|toString()|문자열 출력|


**append() : 문자열 추가**

```
StringBuilder sb = new StringBuilder();
sb.append("ABC");
sb.append("ZXC");
String sentence = sb.toString() // "ABCZXC"
```

**capacity() : 현재 char[] 배열이 가진 사이즈 정보를 반환**

<ul>
String 클래스와 다르게 char[] 배열 사이즈를 여유 있게 잡아둠

length()는 실제 데이터가 들어있는 문자열 자체의 길이이고, capacity()는 현재 배열 사이즈

append() 등 문자열 조정할 때 배열 사이즈가 자동으로 변경됨.

</ul>

```
		StringBuilder a = new StringBuilder("Hello");
		
		System.out.println(a.length());		// 5
		System.out.println(a.capacity()); 	// 21
		
		a.append(" World");
		System.out.println(a);             	// "Hello World"
		
		System.out.println(a.length()); 	// 11
		System.out.println(a.capacity()); 	// 21
		
		a.append(" Hi everybody!!!!");
		System.out.println(a);             	// Hello World Hi everybody!!!!

		System.out.println(a.length()); 	// 28
		System.out.println(a.capacity()); 	// 44		

```

**delete() : 매개변수로 전달받은 인덱스 사이의 문자열 제거**

parameter: 인덱스 시작점, 인덱스 끝점+1

문자열에서 시작과 끝은 항상 **"시작<=범위<끝"** 형태이다.

```
		StringBuilder a = new StringBuilder("Hello");

		a.append(" World");
		System.out.println(a);  // "Hello World"
		
		a.delete(6, 9);         // (6~8 삭제)
		System.out.println(a);  // "Hello ld" 

```

**deleteCharAt() : 특정 인덱스의 한 문자만 삭제**

```
		StringBuilder a = new StringBuilder("Hello");

		a.append(" World");
		System.out.println(a); 				// "Hello World"
		
		// a.delete(6,7) 과 같음
		a.deleteCharAt(6);
		System.out.println(a);				// "Hello orld"

```

**insert() : 특정 위치에 문자열 삽입**

```
		StringBuilder a = new StringBuilder("He World");
		
		a.insert(2, "llo");
		System.out.println(a);			// "Hello World"
		
		a.insert(5, 55);
		System.out.println(a); 			// "Hello55 World"

```

**reverse() : 문자열을 거꾸로 뒤집어줌**

```
		StringBuilder a = new StringBuilder("Hello World");
		
		a.reverse();
		System.out.println(a); 	// "dlroW olleH"			

```

**setCharAt() : 특정 위치의 문자 변경**

insert()가 원본 문자열 중간에 삽입이라면 setCharAt()은 해당 위치의 문자를 변경해줌

```
StringBuilder a = new StringBuilder("Hello World");
		
		a.setCharAt(0, 'h');
		System.out.println(a);		// "hello World"
```

**setLength() : 문자열 길이 조정**

현재 문자열보다 길게 조정하면 공백으로 채워짐

현재 문자열보다 짧게 조정하면 나머지 문자는 삭제됨

```
		StringBuilder a = new StringBuilder("Hello World");
		
		System.out.println(a.length());  // 11
		a.setLength(9);                  // 길이를 9로 줄임
		System.out.println(a + "끝");    // "Hello Wor끝"
		a.setLength(11);                 // 길이를 다시 11로 늘림
		System.out.println(a + "끝");    // "Hello Wor  끝"
```

**trimToSize() : 문자열이 저장된 char[] 배열 사이즈를 현재 문자열 길이와 동일하게 조정**

string 클래스의 trim()이 앞 뒤 공백을 제거하는 것 과 같이 공백 사이즈를 제공하는 것

배열의 남는 사이즈는 공백이므로, 문자열 뒷부분의 공백을 모두 제거해준다고 보면 된다.

```
StringBuilder a = new StringBuilder("Hello World");
		
		System.out.println(a.length());		// 11
		System.out.println(a.capacity());	// 27
		
		a.trimToSize();
		System.out.println(a.capacity()); 	// 11
```