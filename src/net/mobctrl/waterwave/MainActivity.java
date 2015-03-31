package net.mobctrl.waterwave;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * 
 * @author Zheng Haibo
 * @web http://www.mobctrl.net
 *
 */
public class MainActivity extends Activity {

	private WaterWaveView waterWaveView;

	private SeekBar seek_bar1;
	private SeekBar seek_bar2;
	private SeekBar seek_bar3;
	private SeekBar seek_bar4;
	private TextView tv_show;

	private int value1;
	private int value2;
	private int value3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		waterWaveView = (WaterWaveView) findViewById(R.id.wwv);

		seek_bar1 = (SeekBar) findViewById(R.id.seek_bar1);
		seek_bar2 = (SeekBar) findViewById(R.id.seek_bar2);
		seek_bar3 = (SeekBar) findViewById(R.id.seek_bar3);
		seek_bar4 = (SeekBar) findViewById(R.id.seek_bar4);
		tv_show = (TextView) findViewById(R.id.tv_show);

		seek_bar1.setOnSeekBarChangeListener(onSeekBarChangeListener);
		seek_bar2.setOnSeekBarChangeListener(onSeekBarChangeListener);
		seek_bar3.setOnSeekBarChangeListener(onSeekBarChangeListener);
		seek_bar4.setOnSeekBarChangeListener(onSeekBarChangeListener);
	}

	private OnSeekBarChangeListener onSeekBarChangeListener = new OnSeekBarChangeListener() {

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {

		}

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			switch (seekBar.getId()) {
			case R.id.seek_bar1:
				value1 = progress;
				waterWaveView.setOmegaByProgress(progress);
				break;
			case R.id.seek_bar2:
				value2 = progress;
				waterWaveView.setWaveHeightByProgress(progress);
				break;
			case R.id.seek_bar3:
				value3 = progress;
				waterWaveView.setMoveSpeedByProgress(progress);
				break;
			case R.id.seek_bar4:
				waterWaveView.setHeightOffsetByProgress(progress);
				break;
			default:
				break;
			}
			tv_show.setText(String.format(
					"moveSpeed:%s,waveHeight:%s,omega:%s", value3, value2,
					value1));
		}
	};

}
