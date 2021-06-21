package com.spring.pointcut;

public class BehaviorImpl implements Behavior{

	@Override
	public void 잠자기() {
		System.out.println("잔다");
		
	}

	@Override
	public void 공부하기() {
		System.out.println("끄적끄적");		
	}

	@Override
	public void 밥먹기() {
		System.out.println("냠냠");
		
	}

	@Override
	public void 데이트() {
		System.out.println("꽁냥꽁냥");		
	}

	@Override
	public void 운동() {
		System.out.println("쐬질");		
	}

	@Override
	public void 놀기() {
		System.out.println("뿅뿅");		
	}

	@Override
	public void 정신수양() {
		System.out.println("...");		
	}

}
