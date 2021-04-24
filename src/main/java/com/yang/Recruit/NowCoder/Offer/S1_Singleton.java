package com.yang.Recruit.NowCoder.Offer;

// ��ע�� ����ע��  => "/**" + Enter

/**
 * @author wu_ya
 * 
 */
public class S1_Singleton {

	private static S1_Singleton instance;
	private S1_Singleton() {

	}
	
	public void fun() {
		System.out.println("����ʵ�����ɹ�");
	}

	// �̲߳���ȫ
	public static S1_Singleton get() {
		if (instance == null) {
			instance = new S1_Singleton();
		}
		return instance;
	}

	// �̰߳�ȫ

	// ����ģʽ-ֱ�Ӽ���
	// private S1_Singleton(){}
	public static synchronized S1_Singleton get1() {
		if (instance == null) {
			instance = new S1_Singleton();
		}

		return instance;
	}
	
	
	
	// ����ģʽ-˫��У����
	private static volatile S1_Singleton instance2;
	// private S1_Singleton(){}
	public static S1_Singleton get2() {
		if(instance2 == null) { //X: �����ж� ���貽��
			synchronized (S1_Singleton.class) {
				if(instance2 == null) { // t1 t2 ����ִ����X���裬����֮һ�������ͬ���� �������ٴ�ʵ����
					instance2 = new S1_Singleton(); // Y: 1�����ڴ棻2�����ʼ����3ʵ��ָ���ڴ�ռ�
					// volatile��֤123˳��ִ�� �������13<X�зǿ� ����,Zʵ��Ϊ��>2
				}
			}
		}
		return instance2; // Z: Y132ִ�� ��(volatile���� ��ֹYָ������)
	}
	
	

	// ����ģʽ
	private static S1_Singleton instance3 = new S1_Singleton();
	// private S1_Singleton(){}
	public static S1_Singleton get3() {
		return instance3;
	}
	
	

	// ��̬�ڲ���
	// private S1_Singleton(){}
	private static class SingletonHolder{
		private static final S1_Singleton INSTANCE = new S1_Singleton();
	}
	public static S1_Singleton get4() {
		return SingletonHolder.INSTANCE;
	}
	
	
	public static void main(String[] args) {
		S1_Singleton s = S1_Singleton.get4();
		s.fun();
		
	}

}
