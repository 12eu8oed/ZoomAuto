package com.seungho.ZoomAutoExecution; // 패키지 변경
//package ZommAutoTime;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/*전제조건 zoom프로그램 자체가 일단 꺼져 있어야 함*/

@Component
public class ZoomLinkScheduler {
	@Scheduled(initialDelay = 3000, fixedRate = 1000000000) // 애플리케이션 실행 후 5초 후에 처음 실행, 이후에는 매 10초마다 실행
//	@Scheduled(cron = "0 55 18 * * *") // 매일 오후 6시 55분에 실행
	public void openZoomLink() {
		try {
			// 줌 링크
			String zoomLink = "https://us06web.zoom.us/j/9457504897?pwd=VnkvLy9QRHNYTXd5WUFzN0lPb3NwUT09"; // 예배줌 링크
//			String zoomLink = "https://us05web.zoom.us/j/7210200424?pwd=bWFiUHM2TFJjc1Y5Q0VnUDRGempmZz09"; // 형 예배줌 링크

			// 크롬을 실행하여 줌 링크 열기
			Runtime.getRuntime().exec("cmd /c start chrome " + zoomLink);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Spring boot가 기본설정이 headless모드 라고 해서 기본모드 자체를 끔. GUI를 사용할 수 있어야 Robot클래스가 동작한다고 했음.
		System.setProperty("java.awt.headless", "false");

		try {
			// 로봇 생성
			Robot robot = new Robot();

			// 줌 링크가 완전히 로드될 때까지 대기
			robot.delay(5000);
			robot.delay(5000);
//			robot.delay(5000);

			// "zoom meeting 열기" 클릭
			robot.mouseMove(858, 222);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

			// 다음 클릭 이벤트를 위해 잠시 대기
			robot.delay(5000);
			robot.delay(5000);
//			robot.delay(5000);

			// "컴퓨터 오디오로 참가" 클릭
			robot.mouseMove(766, 360);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}