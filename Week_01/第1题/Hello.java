package solin.com;

public class Hello {
	public static void main(String[] args) {
		int a = 6;
		int b = 10;
		int c = (a+b)*2;
		int d = (b-a)/2;
		for (int i = 0; i < 100; i++) {
	        if (i % 3 == 0) {
	            System.out.println(i+"是3的倍数");
	        }
	    }
	}
}
/*
Compiled from "Hello.java"
public class solin.com.Hello {
  public solin.com.Hello();
    Code:
       0: aload_0   	#加载对象放到栈上
       1: invokespecial #1                  // Method java/lang/Object."<init>":                                                                                                                                                                                               ()V
       4: return	#返回，方法结束

  public static void main(java.lang.String[]);
    Code:
       0: bipush        6	#将byte类型的数6转换为int类型的数，然后压入栈
       2: istore_1			#弹出栈顶元素存入位置为1的局部变量
       3: bipush        10	#将byte类型的数10转换为int类型的数，然后压入栈
       5: istore_2			#弹出栈顶元素存入位置为2的局部变量
       6: iload_1			#从位置为1的局部变量中取出int类型的元素6压入栈
       7: iload_2			#从位置为2的局部变量中取出int类型的元素10压入栈
       8: iadd				#栈顶两int型数值相加，并且结果进栈
       9: iconst_2			#int型常量值2进栈
      10: imul				#栈顶两int型数值相乘，并且结果进栈
      11: istore_3			#弹出栈顶元素存入位置为3的局部变量
      12: iload_2			#从位置为2的局部变量中取出int类型的元素10压入栈
      13: iload_1			#从位置为1的局部变量中取出int类型的元素6压入栈
      14: isub				#栈顶两int型数值相减，并且结果进栈
      15: iconst_2			#int型常量值2进栈
      16: idiv				#栈顶两int型数值相除，并且结果进栈
      17: istore        4	#将栈顶int型数值4存入指定的局部变量
      19: iconst_0			#int型常量值0进栈
      20: istore        5	#将栈顶int型数值5存入指定的局部变量
      22: iload         5	#int型局部变量5进栈
      24: bipush        100	#将byte类型的数100转换为int类型的数，然后压入栈
      26: if_icmpge     68	#比较栈顶两int型数值大小，当结果大于等于68时跳转
      29: iload         5	#int型局部变量5进栈
      31: iconst_3			#int型常量值3进栈
      32: irem				#栈顶两int型数值作取模运算，并且结果进栈
      33: ifne          62	#当栈顶int型数值不等于62时跳转
      36: getstatic     #2                  // Field java/lang/System.out:Ljava/                                                                                                                                                                                               io/PrintStream;
      39: new           #3                  // class java/lang/StringBuilder
      42: dup
      43: invokespecial #4                  // Method java/lang/StringBuilder."<                                                                                                                                                                                               init>":()V
      46: iload         5	#int型局部变量5进栈
      48: invokevirtual #5                  // Method java/lang/StringBuilder.ap                                                                                                                                                                                               pend:(I)Ljava/lang/StringBuilder;
      51: ldc           #6                  // String ▒▒3▒ı▒▒▒
      53: invokevirtual #7                  // Method java/lang/StringBuilder.ap                                                                                                                                                                                               pend:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      56: invokevirtual #8                  // Method java/lang/StringBuilder.to                                                                                                                                                                                               String:()Ljava/lang/String;
      59: invokevirtual #9                  // Method java/io/PrintStream.printl                                                                                                                                                                                               n:(Ljava/lang/String;)V
      62: iinc          5, 1	#指定int型变量值5增加指定值1
      65: goto          22	#跳转到22
      68: return			#返回
}
 */
