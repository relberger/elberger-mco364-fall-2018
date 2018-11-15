package elberger.rx;

import com.sun.org.apache.xpath.internal.operations.Bool;
/*import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;*/

public class RxSample
{
	public static void main(String args[])
	{
		/*Observable<Integer> observable = Observable.just(5, 4, 3, 4, 4, 4, 3, 2, 1);


		Disposable disposable = observable
				.filter(integer -> integer % 2 == 0)
				.map(integer -> integer % 2)
				.distinct()
				.sorted()
				.toList()
				*//*.subscribeOn(Schedulers.computation())
				.observeOn(Schedulers.single())*//*
				.subscribe(System.out::println);*/

		/*
		same as ^ Disposable disposable = observable.subscribe(System.out::println);
		Disposable disposable = observable.subscribe(new Consumer<Boolean>()
		{
			@Override
			public void accept(Boolean aBoolean) throws Exception
			{
				System.out.println(aBoolean);
			}
		});

		 */

	}
}
