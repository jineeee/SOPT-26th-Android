package org.sopt.cldi.ui.gomshintalk

import android.graphics.Color
import android.os.Bundle
import android.provider.Settings.System.DATE_FORMAT
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_gomshin_talk.*
import org.sopt.cldi.R
import org.sopt.cldi.data.GomshinTalkData
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class GomshinTalkFragment : Fragment() {

    private var data =  mutableListOf<GomshinTalkData>()
    
    private lateinit var gomshinTalkAdapter: GomshinTalkAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gomshin_talk, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonEvent()
        setAdapter(data)
    }

    //어뎁터 연결 함수
    private fun setAdapter(gomshinTalkItem : MutableList<GomshinTalkData>) {
        rv_gomshin_talk.addItemDecoration(
            GomshinTalkDecoration(
                7,
                Color.rgb(247, 247, 247)
            )
        )
        gomshinTalkAdapter =
            GomshinTalkAdapter(
                gomshinTalkItem,
                this.context!!
            )
        loadDatas()
        rv_gomshin_talk.adapter = gomshinTalkAdapter
    }

    private fun setButtonEvent() {
        btn_best.setOnClickListener {
            it.isSelected = true
            btn_recent.isSelected = false
        }
        btn_recent.setOnClickListener {
            it.isSelected = true
            btn_best.isSelected = false
        }
        btn_search.setOnClickListener {  }
        btn_filter.setOnClickListener {  }
    }


    private fun loadDatas() {
        data.apply {
            add(
                GomshinTalkData(
                    num = 1,
                    title = "곰신톡 1번",
                    level = "Lv.21",
                    nick = "adfadf",
                    like = 210,
                    comment = 528,
                    time = "8시간전",
                    image = null,
                    category = "편지보내기",
                    rank = "해군 일병"
                )
            )
            add(
                GomshinTalkData(
                    num = 2,
                    title = "곰신톡 2번(이미지 존재)",
                    level = "Lv.23",
                    nick = "adfadf",
                    like = 210,
                    comment = 528,
                    time = "2시간전",
                    image = "https://avatars3.githubusercontent.com/u/45380072?s=460&u=b9fc82996ec2cc568a7dfcbf8846944dc16a7ccd&v=4",
                    category = "곰신미니톡",
                    rank = "공군 이등병"

                )
            )
            add(
                GomshinTalkData(
                    num = 3,
                    title = "곰신톡3번(이미지 없음)",
                    level = "Lv.22",
                    nick = "adfadf",
                    like = 210,
                    comment = 528,
                    time = "6시간전",
                    image = null,
                    category = "연애상담",
                    rank = "해병대 병장"
                )
            )
            add(
                GomshinTalkData(
                    num = 4,
                    title = "군계급 매칭 완료",
                    level = "Lv.22",
                    nick = "의경가고싶다",
                    like = 210,
                    comment = 528,
                    time = "6시간전",
                    image = "https://post-phinf.pstatic.net/MjAxNzAyMTlfODkg/MDAxNDg3NDkyNzA2NDk5.-8EvZjoO90a9veRqOynmW7BwbtiLkQUo4om-5BiYiOMg.4_Wk9yRIBcpeIdPzRCrX9ry0qAEZVt4mSWjQTt-mWJMg.PNG/B0E8B1DEC0E5.png",
                    category = "공동구매",
                    rank = "의경 상경"
                )
            )
            add(
                GomshinTalkData(
                    num = 5,
                    title = "카테고리 변경 적용완료",
                    level = "Lv.22",
                    nick = "육군 병장 이미지 매칭",
                    like = 210,
                    comment = 528,
                    time = "6시간전",
                    image = null,
                    category = "곰신사진첩",
                    rank = "육군병장"
                )
            )
        }
        gomshinTalkAdapter.datas = data
        gomshinTalkAdapter.notifyDataSetChanged()
    }

}
