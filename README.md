# algorithm-study

멤버 : 김경희, 김민우, 문홍웅, 이주희, 정유준, 조윤영
  
### 문제 push 하는 법

#### 새로운 브랜치에 올릴 때(new 알고리즘을 시작할 때)
1. 브랜치 이름을 확인한다.  
![image](https://github.com/yoonoi/algorithm-study/assets/94058311/45ef0eae-4ff5-481e-922c-c41043f4a22e)

2. cmd에서 git pull을 한번 한다.(새로생긴 브랜치를 pull받아오기 위해)
3. git branch -a를 해서 현재 로컬 브랜치와, 원격 브랜치 이름을 확인한다.  
![image](https://github.com/yoonoi/algorithm-study/assets/94058311/801dc443-d53e-4ee7-ae9b-ab8f3e8de698)

4. git checkout [원격브랜치이름]을 하면 로컬에 같은 이름의 브랜치가 생성되면서 자동으로 원격 브랜치 내용이 pull된다.  
![image](https://github.com/yoonoi/algorithm-study/assets/94058311/77452987-8f5e-4abc-b964-ebf507e98c6d)

5. 문제를 풀어 해당 폴더에 넣고 git push 또는 git push origin [브랜치이름]를 하면 원격 브랜치에 push된다.     
6. merge할 필요없이 푸쉬 완료!  



#### 기존 브랜치에 추가할 때
1. git branch -a를 해서 내가 원하는 브랜치에 잘 있는지 확인한다.  
2. 잘 있으면 위의 5번부터 진행  
3. 잘 없으면 브랜치를 생성하거나(위의 1번), 기존 브랜치중에 선택(checkout)해서 5번부터 진행  
