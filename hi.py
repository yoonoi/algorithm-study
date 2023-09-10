import pyautogui
import time
import keyboard

# 좌표 설정
player_value = (1531, 309)
checkbox_1 = (1586, 405)
checkbox_2 = (1586, 461)
checkbox_3 = (1586, 517)
checkbox_4 = (1586, 573)
checkbox_5 = (1586, 629)
next_button = (1509, 921)
enforce_button = (1245, 793)
next_button_2 = (1540, 998)

count = 0

while(pyautogui.pixel(807, 256) != (228, 181, 13)):
    if keyboard.is_pressed('c'):
        print("프로그램을 종료합니다.")
        break
    
    count += 1
    print(str(count) + "번째 시도입니다.")
    
    # 선수 가치 2번 클릭
    pyautogui.click(player_value, clicks=2, interval=0.5)

    # 체크박스 클릭
    pyautogui.click(checkbox_1)
    pyautogui.click(checkbox_2)
    pyautogui.click(checkbox_3)
    pyautogui.click(checkbox_4)
    pyautogui.click(checkbox_5)
    time.sleep(1)

    # 다음 클릭
    pyautogui.click(next_button)
    time.sleep(3)

    # 강화 실행 클릭
    pyautogui.click(enforce_button)
    time.sleep(1.5)
    pyautogui.press('s')
    pyautogui.press('spacebar')
    time.sleep(2.5)

    # 다음 클릭
    pyautogui.click(next_button_2)
    time.sleep(2)
    
print("금카 완성! 축하합니다")