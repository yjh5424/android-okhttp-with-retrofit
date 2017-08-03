# Using android-okhttp-retrofit with HTTP
##  
  
<div>  
dependencies {  
    compile fileTree(include: ['*.jar'], dir: 'libs')  
    testCompile 'junit:junit:4.12'  
    compile 'com.android.support:appcompat-v7:23.4.0'  
    **compile 'com.squareup.retrofit2:retrofit:2.3.0'**  
    **compile 'com.squareup.retrofit2:converter-gson:2.3.0'**  
}  
</div>
  


출처: http://swalloow.tistory.com/72 [MyCloud]
## Server APi  
  
  
1.	Print 등록    
-	HTTP Method : POST  
-	URI : /print  
-	Requestbody : name, category, place, location, date, stars, recommend  
-	Ex)  
  
{  
name : “치즈떡볶이”,  
category : 6,  
place : “죠스떡볶이”,  
location : “은행동”,  
date : “2017-07-29”,  
stars : 5,  
recommend : true  
}  
-	성공시 : 상태코드 201  
-	실패시 : 상태코드 400  
  
2.	전체 Print 조회  
-	HTTP Method : GET  
-	URI : /print  
-	응답 : JSONArray (상태코드 : 200)  
실패시 : 상태코드 400  
  
3.	카테고리별 조회  
-	HTTP Method : GET  
-	URI : /print/:category  
ex) /print/1 -> 한식 카테고리, /print/2 -> 중식 카테고리  
-	응답 : JSONArray (상태코드 200)  
실패시 : 상태코드 400  
  
4.	카테고리별 조회 (정렬)  
-	HTTP Method : GET  
-	URI : /print/:category/:sortby  
ex) /print/1/date -> 한식 카테고리 날짜순(최근순)  
, /print/6/stars -> 분식 카테고리 별점순(많은 순)  
-	응답 : JSONArray (상태코드 200)  
실패시 : 상태코드 400  
