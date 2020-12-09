package pt.atp.bobi

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var timer: CountDownTimer? = null
    private var _timerLiveData = MutableLiveData<Long>()
    val timerLiveData: MutableLiveData<Long> = _timerLiveData

    fun starTimer(time: Long) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timerLiveData.postValue(millisUntilFinished / 1000)
            }

            override fun onFinish() {
            }
        }
        timer?.start()
    }
}