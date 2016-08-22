package ihundan.wukonglin.synthesize.quartz;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class QuertzTask {
	
	/**
	 * 每隔多久执行一次
	 */
	@Scheduled(fixedDelay=900000)
	public void task01() {
		System.out.println(" 第一个任务 ，每9秒钟执行一次");
	}
	
	/**
	 * "0 15 10 * * * * * * * * * * * * * * * ? "
	 * 从左边第一位开始，分别表示    秒、分、时、日、月、年 
	 * 	“数字”表示指定时间，
	 *  “*”表示任何时间，
	 *  “,”表示 什么时间和什么时间
	 *  “-”表示什么时间到什么时间
	 *  “?”表示
	 *  “星期几的英文”：出现在月份之后，表示某月的星期几的某个时间执行
	 *  “L”：出现在“日”的位置上，表示某月的最后一天
	 *     ：出现在“月”的位置上，且前面有一个数字，表示某月的最后一个星期几执行
	 *  “#”：出现在“月”的位置上，一般为“N#M”，前面一位表示 星期几，后面一们表示第几个星期必
	 * 例子：
	 * 	1、"0 15 10 ? * *"=="0 15 10 * * ?"=="0 15 10 * * ? *"==每天上午10:15触发
	 *  2、"0 15 10 * * ? 2005"	 	2005年的每天上午10:15触发
	 *  3、"0 * 14 * * ?"	 	在每天下午2点到下午2:59期间的每1分钟触发
	 *  4、"0 0/5 14 * * ?"	 	在每天下午2点到下午2:55期间的每5分钟触发
	 *  5、"0 0/5 14,18 * * ?"	 	在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
	 *  6、"0 0-5 14 * * ?"	 	在每天下午2点到下午2:05期间的每1分钟触发
	 *  
	 *  7、"0 10,44 14 ? 3 WED"	 	每年三月的星期三的下午2:10和2:44触发
	 *  8、"0 15 10 ? * MON-FRI"	 	周一至周五的上午10:15触发
	 *  9、"0 15 10 L * ?"	 	每月最后一日的上午10:15触发
	 *  0、"0 15 10 ? * 6#3"	 	每月的第三个星期五上午10:15触发
	 */
	@Scheduled(cron="0 40 16,17 * * *")
	public void task02() {
		System.out.println("第二个任务，每天下午两点59执行");
	}
}
