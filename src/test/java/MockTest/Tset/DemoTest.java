package MockTest.Tset;

import junit.framework.TestCase;
import java.util.LinkedList;

import static org.mockito.Mockito.*;

public class DemoTest extends TestCase {
	
	public void testget(){
	   
	    // 你可以mock具体的类型,不仅只是接口
	   Demo mockeddemo = mock(Demo.class);

	
	    // 测试桩
	    when(mockeddemo.get(0)).thenReturn("first");
	    when(mockeddemo.get(1)).thenThrow(new RuntimeException());

	  
	    // 输出“first”
	    System.out.println(mockeddemo.get(0));

	
	    // 抛出异常
	    System.out.println(mockeddemo.get(1));


	    // 因为get(2) 没有打桩，因此输出null
	    System.out.println(mockeddemo.get(2));

	    // 验证get(0)被调用的次数
	    System.out.println(verify(mockeddemo).get(0));
	    assertEquals("first",mockeddemo.get(0));
	}

}
