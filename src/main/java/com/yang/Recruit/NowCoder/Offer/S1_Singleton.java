package com.yang.Recruit.NowCoder.Offer;

import org.junit.Test;

// ��ע�� ����ע��  => "/**" + Enter

/**
 * @author wu_ya
 * 
 */
public class S1_Singleton {

	// �̲߳���ȫ
	private static S1_Singleton instance1 = null;

	private S1_Singleton() {

	}

	public S1_Singleton get() {
		if (instance1 == null) {
			instance1 = new S1_Singleton();
		}
		return instance1;
	}

	// �̰߳�ȫ
	// ֱ�Ӽ���

	
	// ����ģʽ
	
	
	//

}
