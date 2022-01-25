package com.survivalcoding.ifkakao.data.datasource

import com.google.gson.Gson
import com.survivalcoding.ifkakao.data.dto.IfKakaoResponse
import com.survivalcoding.ifkakao.data.dto.convert
import com.survivalcoding.ifkakao.domain.entity.Session

class IfKakaoMockDataSource : IfKakaoDataSource {

    private val jsonResponse = """
        {
          "success": true,
          "code": 0,
          "data": [
            {
              "idx": 20,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 15:38:53",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-10 10:39:47",
              "categoryIdx": 6,
              "title": "이용자의 소중한 일상을 지키는 카카오톡",
              "content": "이용자의 소중한 일상을 지키려는 카카오톡의 노력을 소개합니다.\n\n카카오톡의 대화와 사진, 동영상뿐만 아니라 아이디와 비밀번호,\n대용량 파일도 안전하게 보관하는 '톡서랍' 업그레이드,\n디지털 세상에서 내가 나임을 증명할 수 있는 '신분증',\n환경 보호와 개인 정보 보호 두 마리 토끼를 잡는 '톡명함',\n그리고 '오픈채팅'에서의 이용자 보호 조치들에 대한 이야기를 나눕니다.",
              "contentTag": "#카카오톡  #톡서랍업그레이드  #신분증  #톡명함  #오픈채팅이용자보호",
              "spotlightYn": "Y",
              "field": "서비스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "카카오",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3683,
                    "contentsIdx": 20,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423791694",
                    "description": "09:41",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3682,
                    "contentsIdx": 20,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 109555,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403129640",
                    "description": "If Kakao_CPO_1022.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 3677,
                    "contentsIdx": 20,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 170699,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403318460",
                    "description": "***1027_A세션_썸네일_42.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 3678,
                    "contentsIdx": 20,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 87866,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403306708",
                    "description": "***1027_A세션_썸네일_61.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3679,
                    "contentsIdx": 20,
                    "type": "PC_IMAGE",
                    "fileSize": 68188,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403330102",
                    "description": "***1027_A세션_썸네일_2.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3680,
                    "contentsIdx": 20,
                    "type": "MO_IMAGE",
                    "fileSize": 20136,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403338353",
                    "description": "***1027_A세션_썸네일_22.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3681,
                    "contentsIdx": 20,
                    "type": "SHARE_IMAGE",
                    "fileSize": 68188,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403350046",
                    "description": "***1027_A세션_썸네일_2.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 3675,
                    "contentsIdx": 20,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 38760,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403280606",
                    "description": "***1027_A세션_썸네일_79.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 3676,
                    "contentsIdx": 20,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 24294,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635403263604",
                    "description": "***1027_A세션_썸네일_97.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "플랫폼",
                  "디지털자산"
                ],
                "TECH_CLASSIFICATION": [
                  
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1273,
                  "contentsIdx": 20,
                  "nameKo": "김택수",
                  "nameEn": "felix",
                  "company": "카카오",
                  "occupation": "CPO"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오",
              "speakerName": "felix김택수",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 45,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:34:45",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-16 15:51:55",
              "categoryIdx": 6,
              "title": "카카오와 사회혁신가가 만나면:  카카오임팩트 펠로우십 1년의 스토리",
              "content": "혁신가들의 레이블, 카카오임팩트 펠로우십 론칭 후 1년 간의 다양한 시도와 함께 꿈꾸는 변화에 관한 이야기를 소개합니다. \n\n지난 1년 동안 카카오임팩트는 24명의 혁신가를 펠로우로 선정하고, 카카오와 함께 다양한 지원을 해왔습니다. \n그중 혁신가의 목소리와 어젠다를 영향력 있는 콘텐츠와 채널을 통해 널리 알리도록 돕는 ‘확성기’ 지원의 다양한 사례들을 소개하고, 나아가 카카오의 콘텐츠, 기술, 플랫폼과 연계해 사회 문제 해결의 실마리를 찾아가는 이야기를 들려드립니다. \n\n카카오와 사회혁신가가 만나 앞으로 만들게 될 더 나은 세상으로의 변화를 함께 상상해보시기 바랍니다.",
              "contentTag": "#카카오임팩트 #카카오임팩트펠로우십 #펠로우십 #더나은세상 #확성기 #기업재단",
              "spotlightYn": "Y",
              "field": "서비스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "카카오",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4673,
                    "contentsIdx": 45,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423955927",
                    "description": "18:16",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4671,
                    "contentsIdx": 45,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112080,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408142730",
                    "description": "If kakao_impact_1022.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 4672,
                    "contentsIdx": 45,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 117737,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408147897",
                    "description": "If kakao_impact2_1022.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 4666,
                    "contentsIdx": 45,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 99463,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408067686",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 4667,
                    "contentsIdx": 45,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 48171,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408079499",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4668,
                    "contentsIdx": 45,
                    "type": "PC_IMAGE",
                    "fileSize": 26449,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408051998",
                    "description": "임팩트.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4669,
                    "contentsIdx": 45,
                    "type": "MO_IMAGE",
                    "fileSize": 8748,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408092161",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4670,
                    "contentsIdx": 45,
                    "type": "SHARE_IMAGE",
                    "fileSize": 26449,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408057068",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 4664,
                    "contentsIdx": 45,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 19235,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420005992",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 4665,
                    "contentsIdx": 45,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 12715,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420019849",
                    "description": "임팩트.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "플랫폼",
                  "소셜임팩트"
                ],
                "TECH_CLASSIFICATION": [
                  
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1467,
                  "contentsIdx": 45,
                  "nameKo": "육심나",
                  "nameEn": "sienna",
                  "company": "카카오임팩트",
                  "occupation": "사무국장",
                  "channelLink": "https://pf.kakao.com/_MiBCd"
                },
                {
                  "idx": 1468,
                  "contentsIdx": 45,
                  "nameKo": "정연주",
                  "nameEn": "juni",
                  "company": "카카오임팩트",
                  "occupation": "사업팀장"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오",
              "speakerName": "sienna육심나",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 46,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:35:04",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-09 16:21:21",
              "categoryIdx": 6,
              "title": "기술과 혁신으로 금융과 고객의 만남을 더 이롭게",
              "content": "카카오뱅크가 혁신하는 이유는 '고객'입니다. \n\n카카오뱅크는 기술과 혁신으로 고객의 금융 생활을 더 풍요롭고, 재밌고, 행복하게 만들 수 있다고 생각합니다. \n\n카카오뱅크의 기술과 혁신이 만드는 고객의 '더 나은 금융 Life'에 대한 이야기를 나누고자 합니다.",
              "contentTag": "#카카오뱅크 #금융혁신 #금융기술 #금융생활 #고객중심 #더나은금융Life",
              "spotlightYn": "Y",
              "field": "서비스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "카카오뱅크",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3611,
                    "contentsIdx": 46,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423774816",
                    "description": "25:18",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3610,
                    "contentsIdx": 46,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112894,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408208659",
                    "description": "If Kakao_Bank_CEO_1021.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 3605,
                    "contentsIdx": 46,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 839396,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408279954",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 3606,
                    "contentsIdx": 46,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 347381,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408288147",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3607,
                    "contentsIdx": 46,
                    "type": "PC_IMAGE",
                    "fileSize": 173311,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408260152",
                    "description": "뱅크.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3608,
                    "contentsIdx": 46,
                    "type": "MO_IMAGE",
                    "fileSize": 33569,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408268809",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3609,
                    "contentsIdx": 46,
                    "type": "SHARE_IMAGE",
                    "fileSize": 839396,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408236038",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 3603,
                    "contentsIdx": 46,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 40232,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419975187",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 3604,
                    "contentsIdx": 46,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 25368,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419965232",
                    "description": "뱅크.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "핀테크",
                  "디지털자산"
                ],
                "TECH_CLASSIFICATION": [
                  
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1265,
                  "contentsIdx": 46,
                  "nameKo": "윤호영",
                  "nameEn": "daniel",
                  "company": "카카오뱅크",
                  "occupation": "CEO",
                  "channelLink": "https://pf.kakao.com/_SxbmHu"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오뱅크",
              "speakerName": "daniel윤호영",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 50,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:35:57",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-09 16:22:22",
              "categoryIdx": 6,
              "title": "NFT, 크리에이터와 팬을 연결하다",
              "content": "지난 2년이 넘는 시간 동안 그라운드 엑스는 블록체인으로 보다 나은 세상을 만들기 위해 노력해왔습니다.\n\n이제 그라운드 엑스가 GX2.0을 통해 새로운 미래를 준비하려고 합니다.\n바로 블록체인의 킬러 서비스를 통해 디지털 자산의 글로벌 리더\"가 되는 것입니다.\n\n그라운드 엑스는 이를 위해 디지털 자산 기술의 핵심 중 하나인 NFT와 이를 활용한 크리에이터 경제에 집중하고자 합니다.\n오늘 저희가 들려드릴 이야기는 그라운드 엑스가 만들어 가고 있는 블록체인을 통해 누구나 디지털 크리에이터가 될 수 있는 세상\"에 관한 이야기입니다.",
              "contentTag": "#Klaytn #GroundX #Blockchain #NFT #NFTArt #DigitalArt #Kakao",
              "spotlightYn": "Y",
              "field": "서비스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3629,
                    "contentsIdx": 50,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423774382",
                    "description": "40:23",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3628,
                    "contentsIdx": 50,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 120909,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408603748",
                    "description": "If Kakao_ground_X_1022.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 3623,
                    "contentsIdx": 50,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 286682,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408620862",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 3624,
                    "contentsIdx": 50,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 135627,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408632190",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3625,
                    "contentsIdx": 50,
                    "type": "PC_IMAGE",
                    "fileSize": 107726,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408645143",
                    "description": "그라운드.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3626,
                    "contentsIdx": 50,
                    "type": "MO_IMAGE",
                    "fileSize": 25748,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408651713",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3627,
                    "contentsIdx": 50,
                    "type": "SHARE_IMAGE",
                    "fileSize": 107726,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408659096",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 3621,
                    "contentsIdx": 50,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 48830,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420065973",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 3622,
                    "contentsIdx": 50,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 29234,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420075935",
                    "description": "그라운드.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "크리에이터",
                  "디지털자산"
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1267,
                  "contentsIdx": 50,
                  "nameKo": "한재선",
                  "nameEn": "jason",
                  "company": "그라운드X",
                  "occupation": "CEO"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "jason한재선",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 51,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:36:19",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-09 16:22:46",
              "categoryIdx": 6,
              "title": "카카오엔터프라이즈가 그려가고 있는  Enterprise IT",
              "content": "카카오엔터프라이즈호가 출항을 한 지 2주년을 맞이했습니다. \n카카오엔터프라이즈가 일궈낸 기술과 비즈니스 성과를 소개하고, 우리가 어떤 회사인지, 어떤 차별점을 갖는지, 궁극적으로 지향하는 바를 나누고자 합니다. \n끝으로 함께 성장하고 상생하고자 하는 노력, 그리고 우수한 개발자들과 함께 만들어갈 미래에 대해 이야기할 예정입니다.",
              "contentTag": "#카카오엔터프라이즈 #AI #클라우드 #상생 #동반성장 #Enterprise #IT #B2B #디지털혁신 ",
              "spotlightYn": "Y",
              "field": "서비스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "카카오엔터프라이즈",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3638,
                    "contentsIdx": 51,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423774672",
                    "description": "09:25",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3637,
                    "contentsIdx": 51,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 93556,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408788415",
                    "description": "If Kakao_Enterprise_CEO_1021.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 3632,
                    "contentsIdx": 51,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 286032,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408760333",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 3633,
                    "contentsIdx": 51,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 153205,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408749130",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3634,
                    "contentsIdx": 51,
                    "type": "PC_IMAGE",
                    "fileSize": 116584,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408717285",
                    "description": "엔터프.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3635,
                    "contentsIdx": 51,
                    "type": "MO_IMAGE",
                    "fileSize": 32358,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408738538",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3636,
                    "contentsIdx": 51,
                    "type": "SHARE_IMAGE",
                    "fileSize": 116584,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408721420",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 3630,
                    "contentsIdx": 51,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 5790,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420150435",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 3631,
                    "contentsIdx": 51,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 4113,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635420122864",
                    "description": "엔터프.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "B2B",
                  "플랫폼"
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI",
                  "클라우드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1268,
                  "contentsIdx": 51,
                  "nameKo": "백상엽",
                  "nameEn": "andrew",
                  "company": "카카오엔터프라이즈",
                  "occupation": "CEO",
                  "channelLink": "https://pf.kakao.com/_lVmtT"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오엔터프라이즈",
              "speakerName": "andrew백상엽",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 44,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:33:20",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-11 10:24:31",
              "categoryIdx": 6,
              "title": "함께 성장하는 카카오 비즈니스",
              "content": "파트너와 유저가 함께 성장하는 카카오 비즈니스 이야기입니다.\n파트너에게는 데이터의 투명한 공유! 이용자에게는 꼭 필요한 메시지만 제공!\n\n톡 안에서 비즈니스를 완결성 있게 풀어주는 솔루션, 이제 거래형 플랫폼으로 진화하는 ‘톡 비즈니스’를 그려봅니다.",
              "contentTag": "#카카오톡채널  #거래형플랫폼  #카카오비즈니스",
              "spotlightYn": "Y",
              "field": "비즈니스",
              "sessionType": "A Type",
              "commentYn": "Y",
              "company": "카카오",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4277,
                    "contentsIdx": 44,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423813229",
                    "description": "15:52",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4276,
                    "contentsIdx": 44,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 103383,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407865550",
                    "description": "If Kakao_CBO_1021.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 4271,
                    "contentsIdx": 44,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 85289,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407896349",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 4272,
                    "contentsIdx": 44,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 44015,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407905563",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4273,
                    "contentsIdx": 44,
                    "type": "PC_IMAGE",
                    "fileSize": 25394,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407917794",
                    "description": "비즈니스.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4274,
                    "contentsIdx": 44,
                    "type": "MO_IMAGE",
                    "fileSize": 8042,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407927876",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4275,
                    "contentsIdx": 44,
                    "type": "SHARE_IMAGE",
                    "fileSize": 25394,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635407940197",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 4269,
                    "contentsIdx": 44,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 14967,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419892697",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 4270,
                    "contentsIdx": 44,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 9715,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419908015",
                    "description": "비즈니스.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  "플랫폼",
                  "구독",
                  "파트너성장"
                ],
                "TECH_CLASSIFICATION": [
                  
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1385,
                  "contentsIdx": 44,
                  "nameKo": "이종원",
                  "nameEn": "zedd",
                  "company": "카카오",
                  "occupation": "CBO"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오",
              "speakerName": "zedd이종원",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 48,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 16:35:32",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-16 18:49:59",
              "categoryIdx": 6,
              "title": "카카오브레인, Unthinkable Question",
              "content": "AI 서비스로 모두에게 따뜻한 친구가 되어줄 수 있을까?\n최고의 AI 기술을 100배 더 좋게 만들 수 있을까?\n\n모든 혁신은 생각하지 못한 물음으로부터 비롯된다고 믿습니다\n연구, 기술, 서비스 모든 영역에서 만들어내는 Unthinkable 임팩트를 만듭니다\n\nAI가 모두의 삶에 당연해지는 Unithinkable Life를 준비합니다\n카카오브레인 시즌 2.0을 소개합니다.",
              "contentTag": " #kakaobrain2.0 #AIstartup #Unthinkable_Question #impactful_answer",
              "spotlightYn": "Y",
              "field": "기술",
              "sessionType": "A Type",
              "qnaStartDay": "1",
              "qnaStartTime": "10:00",
              "qnaEndTime": "11:00",
              "commentYn": "Y",
              "company": "카카오브레인",
              "reservationDate": "20211116",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4682,
                    "contentsIdx": 48,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423963887",
                    "description": "09:09",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4681,
                    "contentsIdx": 48,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 101105,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635408386961",
                    "description": "If Kakao_Brain_CEO_1021.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  {
                    "idx": 4676,
                    "contentsIdx": 48,
                    "type": "PC_MAIN_IMAGE",
                    "fileSize": 93361,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353066938",
                    "description": "step3main_pc_2.png",
                    "mainYn": "N"
                  }
                ],
                "MO_MAIN_IMAGE": [
                  {
                    "idx": 4677,
                    "contentsIdx": 48,
                    "type": "MO_MAIN_IMAGE",
                    "fileSize": 49744,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353075510",
                    "description": "step3main_mo_2.png",
                    "mainYn": "N"
                  }
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4678,
                    "contentsIdx": 48,
                    "type": "PC_IMAGE",
                    "fileSize": 35488,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353085517",
                    "description": "session_img_pc_2.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4679,
                    "contentsIdx": 48,
                    "type": "MO_IMAGE",
                    "fileSize": 11981,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353102431",
                    "description": "session_img_mo_2.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4680,
                    "contentsIdx": 48,
                    "type": "SHARE_IMAGE",
                    "fileSize": 35488,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353090442",
                    "description": "session_img_pc_2.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  {
                    "idx": 4674,
                    "contentsIdx": 48,
                    "type": "PC_SPOTLIGHT",
                    "fileSize": 6544,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353036681",
                    "description": "브레인.png",
                    "mainYn": "N"
                  }
                ],
                "MO_SPOTLIGHT": [
                  {
                    "idx": 4675,
                    "contentsIdx": 48,
                    "type": "MO_SPOTLIGHT",
                    "fileSize": 5154,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636353048513",
                    "description": "spotlight_mo_2.png",
                    "mainYn": "N"
                  }
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI",
                  "데이터",
                  "클라우드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  "1Day"
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1469,
                  "contentsIdx": 48,
                  "nameKo": "김일두",
                  "nameEn": "curtis",
                  "company": "카카오브레인",
                  "occupation": "CEO",
                  "loginEmail": "aaabb@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오브레인",
              "speakerName": "curtis김일두",
              "speakerLoginYn": "N",
              "reservationUTC": 1636992000000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
           {
              "idx": 93,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:13:36",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:14:11",
              "categoryIdx": 7,
              "title": "고성능 블록체인 지갑 서비스 Klip 개발기",
              "content": "바닥부터 설계한 웹 기반 블록체인 지갑 서비스 개발 노하우 공유",
              "contentTag": "#golang #react #webserver #블록체인",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3827,
                    "contentsIdx": 93,
                    "type": "FILE",
                    "fileSize": 775185,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636524850648",
                    "description": "고성능 블록체인 지갑 서비스 Klip 개발기_바닥부터 설계한 웹서비스 개발 노하우 공유.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3826,
                    "contentsIdx": 93,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423595377",
                    "description": "17:47",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3825,
                    "contentsIdx": 93,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 100136,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418463159",
                    "description": "0915_그라운드X_Albert.Nah.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3822,
                    "contentsIdx": 93,
                    "type": "PC_IMAGE",
                    "fileSize": 35627,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418494827",
                    "description": "0915_그라운드X_Albert.Nah_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3823,
                    "contentsIdx": 93,
                    "type": "MO_IMAGE",
                    "fileSize": 22392,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418487513",
                    "description": "0915_그라운드X_Albert.Nah_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3824,
                    "contentsIdx": 93,
                    "type": "SHARE_IMAGE",
                    "fileSize": 35627,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418479514",
                    "description": "0915_그라운드X_Albert.Nah_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1298,
                  "contentsIdx": 93,
                  "nameKo": "나정호",
                  "nameEn": "albert",
                  "company": "그라운드X",
                  "occupation": "블록체인지갑개발팀",
                  "loginEmail": "jeongho.nah@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "albert나정호",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 94,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:15:26",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:41:30",
              "categoryIdx": 7,
              "title": "Distributed tracing 도입기 - Microservice architecture에서의 debugging",
              "content": "쿠버네티스 위에 서비스를 런칭한 뒤 가시성을 확보하기 위해 Observability 요소 중 하나인 분산 트레이싱을 도입하고 사용했던 사례를 공유",
              "contentTag": "#Kubernetes #Cloud #Observability #Tracing #ServiceMesh",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "2",
              "qnaStartTime": "11:00",
              "qnaEndTime": "12:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4183,
                    "contentsIdx": 94,
                    "type": "FILE",
                    "fileSize": 3334814,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526486542",
                    "description": "Distributed tracing 도입기_Microservice architecture 에서의 debugging.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4182,
                    "contentsIdx": 94,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423595401",
                    "description": "15:53",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4181,
                    "contentsIdx": 94,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112669,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418958611",
                    "description": "0908_그라운드X_Jade.Jung.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4178,
                    "contentsIdx": 94,
                    "type": "PC_IMAGE",
                    "fileSize": 47424,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419026241",
                    "description": "0908_그라운드X_Jade.Jung_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4179,
                    "contentsIdx": 94,
                    "type": "MO_IMAGE",
                    "fileSize": 26020,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419043480",
                    "description": "0908_그라운드X_Jade.Jung_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4180,
                    "contentsIdx": 94,
                    "type": "SHARE_IMAGE",
                    "fileSize": 47424,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635419055448",
                    "description": "0908_그라운드X_Jade.Jung_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "인프라/DevOps",
                  "클라우드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1369,
                  "contentsIdx": 94,
                  "nameKo": "정초아",
                  "nameEn": "jade",
                  "company": "그라운드X",
                  "occupation": "DevOps팀",
                  "loginEmail": "whoisxx1@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "jade정초아",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 95,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:16:34",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-16 09:41:23",
              "categoryIdx": 7,
              "title": "Klaytn을 이용하여 NFT 활용하기: 발행부터 판매까지",
              "content": "요새 화두가 되고 있는 NFT를 클레이튼에서 어떻게 발행/전송/매매할 수 있는지 살펴보려고 합니다. 또한 미술시장에서 논의되고 있는 추급권을 스마트 컨트랙트를 이용하여 어떻게 구현할 수 있는지 설명합니다. 스마트 컨트랙트를 이용하면 매매 즉시 추급권 및 거래수수료 정산을 마칠 수 있습니다. 이어서 추급권을 포함한 NFT 매매 전체 시나리오를 설명드리고, 남은 향후 과제는 어떤 것들이 있는지 말씀드리고자 합니다.\n\n💬 이 세션은 소셜 오디오 플랫폼 음mm에서 연사자와 직접 만나는 After Talk이 마련되어 있습니다.\n\n🎙 블록체인, NFT 어디까지 알아보셨어요?\nᄂ 일시 : 11월 22일(월) 17:00 ~ 17:30\nᄂ 링크 : https://www.mm.xyz/event/d321a7a0-d34e-44d3-8bcd-658290cef28d\n\n잠깐! 음mm은 모바일 전용 App입니다.\n- Android 사용자 음mm 다운로드  https://play.google.com/store/apps/details?id=com.kakao.mmoa \n- iOS 사용자 음mm 다운로드  https://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#NFT #NFT마켓 #추급권 #Royalty #스마트컨트랙트",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "16:00",
              "qnaEndTime": "17:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4629,
                    "contentsIdx": 95,
                    "type": "FILE",
                    "fileSize": 2628001,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526317627",
                    "description": "클레이튼에서 NFT 활용하기_발행부터 판매까지.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4628,
                    "contentsIdx": 95,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423595395",
                    "description": "21:09",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4627,
                    "contentsIdx": 95,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 109679,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418400584",
                    "description": "0831_그라운드X_Colin.Kim.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4624,
                    "contentsIdx": 95,
                    "type": "PC_IMAGE",
                    "fileSize": 39969,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418430983",
                    "description": "0831_그라운드X_Colin.Kim_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4625,
                    "contentsIdx": 95,
                    "type": "MO_IMAGE",
                    "fileSize": 23432,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418424371",
                    "description": "0831_그라운드X_Colin.Kim_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4626,
                    "contentsIdx": 95,
                    "type": "SHARE_IMAGE",
                    "fileSize": 39969,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418416486",
                    "description": "0831_그라운드X_Colin.Kim_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1461,
                  "contentsIdx": 95,
                  "nameKo": "김정현",
                  "nameEn": "colin",
                  "company": "그라운드X",
                  "occupation": "블록체인지갑개발팀",
                  "loginEmail": "colin.kim@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "colin김정현",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 96,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:17:24",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:20:54",
              "categoryIdx": 7,
              "title": "블록체인 비호환 변경 a.k.a 하드 포크",
              "content": "블록체인의 호환되지 않는 변경인 하드포크 개념과 함께 다가오는 클레이튼 비호환 변경을 소개하고자 합니다.",
              "contentTag": "#블록체인 #Klaytn #하드포크",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3907,
                    "contentsIdx": 96,
                    "type": "FILE",
                    "fileSize": 415087,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525253901",
                    "description": "블록체인 비호환변경_a.k.a 하드포크.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3906,
                    "contentsIdx": 96,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423595997",
                    "description": "14:30",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3905,
                    "contentsIdx": 96,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 98420,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418882080",
                    "description": "0831_그라운드X_Yumiel.Ko.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3902,
                    "contentsIdx": 96,
                    "type": "PC_IMAGE",
                    "fileSize": 66242,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418904875",
                    "description": "0831_그라운드X_Yumiel.Ko_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3903,
                    "contentsIdx": 96,
                    "type": "MO_IMAGE",
                    "fileSize": 31459,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418917847",
                    "description": "0831_그라운드X_Yumiel.Ko_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3904,
                    "contentsIdx": 96,
                    "type": "SHARE_IMAGE",
                    "fileSize": 66242,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418925614",
                    "description": "0831_그라운드X_Yumiel.Ko_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1313,
                  "contentsIdx": 96,
                  "nameKo": "고유미",
                  "nameEn": "yumiel",
                  "company": "그라운드X",
                  "occupation": "블록체인 플랫폼 개발팀",
                  "loginEmail": "yoomee1313@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "yumiel고유미",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 97,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:19:15",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:08:35",
              "categoryIdx": 7,
              "title": "Traffic Time/Speed Prediction of Kakao Mobility",
              "content": "딥러닝 기반의 도로 속도 예측을 위한 데이터 처리, 모델링, 서빙 경험을 공유합니다.",
              "contentTag": "#교통예측 #Tensorflow #예측모델",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오모빌리티",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3786,
                    "contentsIdx": 97,
                    "type": "FILE",
                    "fileSize": 70052612,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636524507332",
                    "description": "Traffic Time_Speed Prediction  of Kakao Mobility.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3785,
                    "contentsIdx": 97,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596014",
                    "description": "13:09",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3784,
                    "contentsIdx": 97,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 106019,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418797615",
                    "description": "0907_카카오모빌리티_Dominic.Jmkim.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3781,
                    "contentsIdx": 97,
                    "type": "PC_IMAGE",
                    "fileSize": 43698,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418810193",
                    "description": "0907_카카오모빌리티_Dominic.Jmkim_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3782,
                    "contentsIdx": 97,
                    "type": "MO_IMAGE",
                    "fileSize": 25261,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418818772",
                    "description": "0907_카카오모빌리티_Dominic.Jmkim_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3783,
                    "contentsIdx": 97,
                    "type": "SHARE_IMAGE",
                    "fileSize": 43698,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418830598",
                    "description": "0907_카카오모빌리티_Dominic.Jmkim_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1291,
                  "contentsIdx": 97,
                  "nameKo": "김정민",
                  "nameEn": "dominic",
                  "company": "카카오모빌리티",
                  "occupation": "인텔리전스연구팀",
                  "loginEmail": "dominic.jmkim@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오모빌리티",
              "speakerName": "dominic김정민",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 98,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:21:20",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:24:14",
              "categoryIdx": 7,
              "title": "Klaytn Blockchain API의 수평적 확장",
              "content": "클레이튼 노드를 개선하여 API 기능에 대한 수평적 확장성을 가지게 만드는 내용입니다. 하나의 노드가 아닌 다수의 클레이튼 노드를 이용하여 API 서비스를 안정적이고 일관되게 제공할 수 있는 구조를 제안합니다. 개발 과정에서 경험하는 문제를 하나씩 해결해 나가는 과정을 보며 클레이튼 노드가 가진 특징들도 확인하실 수 있습니다.",
              "contentTag": "#블록체인 #기타",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3946,
                    "contentsIdx": 98,
                    "type": "FILE",
                    "fileSize": 636895,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525448931",
                    "description": "Klaytn Blockchain API의 수평적 확장_Klaytn Endpoint System (KES).pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3945,
                    "contentsIdx": 98,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423595414",
                    "description": "16:36",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3944,
                    "contentsIdx": 98,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112639,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418314892",
                    "description": "0908_그라운드X_Aidan.Kwon.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3941,
                    "contentsIdx": 98,
                    "type": "PC_IMAGE",
                    "fileSize": 67628,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418375440",
                    "description": "0908_그라운드X_Aidan.Kwon_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3942,
                    "contentsIdx": 98,
                    "type": "MO_IMAGE",
                    "fileSize": 33010,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418364436",
                    "description": "0908_그라운드X_Aidan.Kwon_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3943,
                    "contentsIdx": 98,
                    "type": "SHARE_IMAGE",
                    "fileSize": 67628,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418352345",
                    "description": "0908_그라운드X_Aidan.Kwon_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1322,
                  "contentsIdx": 98,
                  "nameKo": "권동환",
                  "nameEn": "aidan",
                  "company": "그라운드X",
                  "occupation": "블록체인플랫폼개발팀",
                  "loginEmail": "donghwan.kwon@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "aidan권동환",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 99,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:28:01",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:35:14",
              "categoryIdx": 7,
              "title": "카카오 T 바이크 신규 모델 런칭 스토리",
              "content": "신규 카카오 T 바이크 런칭 과정에서 발생한 기술적인 문제들을 해결해나가는 일련의 과정들을 소개합니다.",
              "contentTag": "#IoT #tcp #network",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오모빌리티",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4063,
                    "contentsIdx": 99,
                    "type": "FILE",
                    "fileSize": 34829016,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526111723",
                    "description": "카카오 T 바이크  신규모델 런칭 스토리.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4062,
                    "contentsIdx": 99,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596021",
                    "description": "15:12",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4061,
                    "contentsIdx": 99,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 103312,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418224398",
                    "description": "0910_카카오모빌리티_Jkob.Lee.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4058,
                    "contentsIdx": 99,
                    "type": "PC_IMAGE",
                    "fileSize": 43322,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418247787",
                    "description": "0910_카카오모빌리티_Jkob.Lee_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4059,
                    "contentsIdx": 99,
                    "type": "MO_IMAGE",
                    "fileSize": 23840,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418240241",
                    "description": "0910_카카오모빌리티_Jkob.Lee_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4060,
                    "contentsIdx": 99,
                    "type": "SHARE_IMAGE",
                    "fileSize": 43322,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418233471",
                    "description": "0910_카카오모빌리티_Jkob.Lee_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "백엔드",
                  "IoT"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1344,
                  "contentsIdx": 99,
                  "nameKo": "이왕석",
                  "nameEn": "jkob",
                  "company": "카카오모빌리티",
                  "occupation": "공통서비스개발팀",
                  "loginEmail": "seok0721@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오모빌리티",
              "speakerName": "jkob이왕석",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 100,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:29:46",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:20:33",
              "categoryIdx": 7,
              "title": "모빌리티 서비스를 위한 ML Lifecycle 자동화",
              "content": "서비스 환경이 변화함에 따라 그 기반이 되는 ML모델도 다시 학습되어야 합니다. 모빌리티 서비스를 위해 ML Lifecycle을 자동화한 경험을 공유합니다.",
              "contentTag": "#ML #MLOps #Automation",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오모빌리티",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3901,
                    "contentsIdx": 100,
                    "type": "FILE",
                    "fileSize": 20491855,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525231136",
                    "description": "모빌리티 서비스를 위한  ML Lifecycle 자동화.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3900,
                    "contentsIdx": 100,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596226",
                    "description": "13:06",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3899,
                    "contentsIdx": 100,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 98365,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418159617",
                    "description": "0907_카카오모빌리티_Carl.Csms.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3896,
                    "contentsIdx": 100,
                    "type": "PC_IMAGE",
                    "fileSize": 51657,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418170862",
                    "description": "0907_카카오모빌리티_Carl.Csms_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3897,
                    "contentsIdx": 100,
                    "type": "MO_IMAGE",
                    "fileSize": 29685,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418177719",
                    "description": "0907_카카오모빌리티_Carl.Csms_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3898,
                    "contentsIdx": 100,
                    "type": "SHARE_IMAGE",
                    "fileSize": 51657,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418185869",
                    "description": "0907_카카오모빌리티_Carl.Csms_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1312,
                  "contentsIdx": 100,
                  "nameKo": "김장현",
                  "nameEn": "carl",
                  "company": "카카오모빌리티",
                  "occupation": "데이터엔지니어링팀",
                  "loginEmail": "cgfree@naver.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오모빌리티",
              "speakerName": "carl김장현",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 101,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:31:55",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:28:35",
              "categoryIdx": 7,
              "title": "KakaoGame SDK의 Robustness 키우기",
              "content": "카카오게임의 안정적인 서비스를 위해서 SDK 개발과정에서 발생했던 이슈들을 공유합니다.",
              "contentTag": "#iOS #Android #Client #모바일 #SDK",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오게임즈",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3970,
                    "contentsIdx": 101,
                    "type": "FILE",
                    "fileSize": 1198730,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525711337",
                    "description": "KakaoGameSDK의 Robustness 키우기.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3969,
                    "contentsIdx": 101,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596235",
                    "description": "15:22",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3968,
                    "contentsIdx": 101,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 96117,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418081206",
                    "description": "0908_카카오게임즈_Eric.J.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3965,
                    "contentsIdx": 101,
                    "type": "PC_IMAGE",
                    "fileSize": 67830,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418105993",
                    "description": "0908_카카오게임즈_Eric.J_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3966,
                    "contentsIdx": 101,
                    "type": "MO_IMAGE",
                    "fileSize": 31250,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418113147",
                    "description": "0908_카카오게임즈_Eric.J_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3967,
                    "contentsIdx": 101,
                    "type": "SHARE_IMAGE",
                    "fileSize": 67830,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418120611",
                    "description": "0908_카카오게임즈_Eric.J_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "iOS",
                  "모바일",
                  "Android"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1326,
                  "contentsIdx": 101,
                  "nameKo": "정승우",
                  "nameEn": "eric",
                  "company": "카카오게임즈",
                  "occupation": "SDK팀",
                  "loginEmail": "swzzang85@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오게임즈",
              "speakerName": "eric정승우",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 102,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:32:33",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:35:55",
              "categoryIdx": 7,
              "title": "카카오모빌리티의 MLOps 도입기",
              "content": "카카오모빌리티의 MLOps 도입 초기 주요 key points 소개합니다.",
              "contentTag": "#ML #MLOps",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오모빌리티",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4083,
                    "contentsIdx": 102,
                    "type": "FILE",
                    "fileSize": 693788,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526152575",
                    "description": "카카오모빌리티의 MLOps 도입기_도입 초기의 주요 key points 소개.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4082,
                    "contentsIdx": 102,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596028",
                    "description": "11:55",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4081,
                    "contentsIdx": 102,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 104545,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418711520",
                    "description": "0907_카카오모빌리티_Zlatan.El.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4078,
                    "contentsIdx": 102,
                    "type": "PC_IMAGE",
                    "fileSize": 68770,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418726827",
                    "description": "0907_카카오모빌리티_Zlatan.El_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4079,
                    "contentsIdx": 102,
                    "type": "MO_IMAGE",
                    "fileSize": 33971,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418743047",
                    "description": "0907_카카오모빌리티_Zlatan.El_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4080,
                    "contentsIdx": 102,
                    "type": "SHARE_IMAGE",
                    "fileSize": 68770,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418752553",
                    "description": "0907_카카오모빌리티_Zlatan.El_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1349,
                  "contentsIdx": 102,
                  "nameKo": "이동우",
                  "nameEn": "zlatan",
                  "company": "카카오모빌리티",
                  "occupation": "인텔리전스연구팀",
                  "loginEmail": "kysersoze.lee@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오모빌리티",
              "speakerName": "zlatan이동우",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 103,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:35:43",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:31:47",
              "categoryIdx": 7,
              "title": "안드로이드 기반 키오스크 개발 시작하기",
              "content": "카카오 T 주차 무인 정산기를 개발하면서 알게된 키오스크에 필요한 기능 및 구현 방법을 소개합니다.",
              "contentTag": "#Android #Kiosk",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오모빌리티",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3982,
                    "contentsIdx": 103,
                    "type": "FILE",
                    "fileSize": 75085197,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525904183",
                    "description": "안드로이드 기반 키오스크 개발 시작하기_주차 무인 정산기 개발 사례 공유.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3981,
                    "contentsIdx": 103,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596231",
                    "description": "20:25",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3980,
                    "contentsIdx": 103,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112654,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418564452",
                    "description": "0907_카카오모빌리티_Justin.And.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3977,
                    "contentsIdx": 103,
                    "type": "PC_IMAGE",
                    "fileSize": 209315,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418579587",
                    "description": "0907_카카오모빌리티_Justin.And_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3978,
                    "contentsIdx": 103,
                    "type": "MO_IMAGE",
                    "fileSize": 56551,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418615078",
                    "description": "0907_카카오모빌리티_Justin.And_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3979,
                    "contentsIdx": 103,
                    "type": "SHARE_IMAGE",
                    "fileSize": 209315,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418648748",
                    "description": "0907_카카오모빌리티_Justin.And_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "Android",
                  "IoT",
                  "모바일"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1328,
                  "contentsIdx": 103,
                  "nameKo": "이재훈",
                  "nameEn": "justin",
                  "company": "카카오모빌리티",
                  "occupation": "카오너클라이언트팀",
                  "loginEmail": "justin.and@kakaomobility.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오모빌리티",
              "speakerName": "justin이재훈",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 104,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:36:33",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-16 09:40:24",
              "categoryIdx": 7,
              "title": "Open Water Diver? OpenSource Diver!",
              "content": "주니어 개발자의 관점에서 장애 상황을 파악했던 경험을 공유합니다.\n어디서 장애가 발생하였는지, 왜 장애가 발생하였는지를 알아가는 과정을 ThreadDump, SoftReference, HashCollision 세 가지 키워드로 설명합니다.\n장애 키워드와 관련된 오픈소스를 보면서 궁금한 점들을 파헤쳐 나갑니다.\n\n💬 이 세션은 소셜 오디오 플랫폼 음mm에서 연사자와 직접 만나는 After Talk이 마련되어 있습니다.\n\n🎙 카카오커머스에서는 어떻게 일할까?💬\nᄂ 일시 : 11월 23일(화) 14:00 ~ 15:00 \nᄂ 링크 : https://www.mm.xyz/event/21ad6e23-3e0c-4684-8094-4dd28d84d624\n\n잠깐! 음mm은 모바일 전용 App입니다.\n- Android 사용자 음mm 다운로드  https://play.google.com/store/apps/details?id=com.kakao.mmoa\n- iOS 사용자 음mm 다운로드  https://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#Java #소프트참조 #해시충돌 #백엔드",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "2",
              "qnaStartTime": "15:00",
              "qnaEndTime": "16:00",
              "commentYn": "Y",
              "company": "카카오커머스",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4611,
                    "contentsIdx": 104,
                    "type": "FILE",
                    "fileSize": 37109303,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636524881626",
                    "description": "Open Water Diver Open Source Diver.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4610,
                    "contentsIdx": 104,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596261",
                    "description": "19:19",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4609,
                    "contentsIdx": 104,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 113407,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418005576",
                    "description": "0913_카카오커머스_Cheeze.Ball.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4606,
                    "contentsIdx": 104,
                    "type": "PC_IMAGE",
                    "fileSize": 38653,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418046098",
                    "description": "0913_카카오커머스_Cheeze.Ball_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4607,
                    "contentsIdx": 104,
                    "type": "MO_IMAGE",
                    "fileSize": 23286,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418024453",
                    "description": "0913_카카오커머스_Cheeze.Ball_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4608,
                    "contentsIdx": 104,
                    "type": "SHARE_IMAGE",
                    "fileSize": 38653,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418037444",
                    "description": "0913_카카오커머스_Cheeze.Ball_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "백엔드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1458,
                  "contentsIdx": 104,
                  "nameKo": "박지혜",
                  "nameEn": "cheeze",
                  "company": "카카오커머스",
                  "occupation": "주문개발파트",
                  "loginEmail": "youo78@naver.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오커머스",
              "speakerName": "cheeze박지혜",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 105,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:37:12",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-17 13:33:05",
              "categoryIdx": 7,
              "title": "Angular의 Dependency Injection 왜 필요한가요?",
              "content": "Angular의 Dependency Injection 시스템에 대해 깊게 살펴봅니다. 그리고 그것들이 실무에서 어떻게 유용하게 사용되고 있는지 소개합니다.\n\n💬 이 세션은 소셜 오디오 플랫폼 음mm에서 연사자와 직접 만나는 After Talk이 마련되어 있습니다.\n\n🎙 카카오커머스에서는 어떻게 일할까?💬\nᄂ 일시 : 11월 23일(화) 14:00 ~ 15:00 \nᄂ 링크 : https://www.mm.xyz/event/21ad6e23-3e0c-4684-8094-4dd28d84d624\n\n잠깐! 음mm은 모바일 전용 App입니다.\n- Android 사용자 음mm 다운로드  https://play.google.com/store/apps/details?id=com.kakao.mmoa\n- iOS 사용자 음mm 다운로드  https://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#angular #frontend #javascript",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "2",
              "qnaStartTime": "15:00",
              "qnaEndTime": "16:00",
              "commentYn": "Y",
              "company": "카카오커머스",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4708,
                    "contentsIdx": 105,
                    "type": "FILE",
                    "fileSize": 2246593,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526583683",
                    "description": "Angular Dependency Injection  그게 왜 필요한가요.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4707,
                    "contentsIdx": 105,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596236",
                    "description": "15:44",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4706,
                    "contentsIdx": 105,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 93726,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418465807",
                    "description": "0913_카카오커머스_Johnny.Dev.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4703,
                    "contentsIdx": 105,
                    "type": "PC_IMAGE",
                    "fileSize": 99161,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418476536",
                    "description": "0913_카카오커머스_Johnny.Dev_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4704,
                    "contentsIdx": 105,
                    "type": "MO_IMAGE",
                    "fileSize": 42484,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418483468",
                    "description": "0913_카카오커머스_Johnny.Dev_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4705,
                    "contentsIdx": 105,
                    "type": "SHARE_IMAGE",
                    "fileSize": 99161,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418495091",
                    "description": "0913_카카오커머스_Johnny.Dev_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "웹/프론트엔드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1475,
                  "contentsIdx": 105,
                  "nameKo": "김민형",
                  "nameEn": "johnny",
                  "company": "카카오커머스",
                  "occupation": "FE개발파트",
                  "loginEmail": "romz1212@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오커머스",
              "speakerName": "johnny김민형",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 106,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:38:55",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-16 09:40:08",
              "categoryIdx": 7,
              "title": "Commerce Query data Rebuild Success 했을까",
              "content": "데이터 문제로 골치 아팠던 상황을 CQRS를 이용해 해결했던 경험을 공유합니다.\n\n💬 이 세션은 소셜 오디오 플랫폼 음mm에서 연사자와 직접 만나는 After Talk이 마련되어 있습니다.\n\n🎙 카카오커머스에서는 어떻게 일할까?💬\nᄂ 일시 : 11월 23일(화) 14:00 ~ 15:00 \nᄂ 링크 : https://www.mm.xyz/event/21ad6e23-3e0c-4684-8094-4dd28d84d624\n\n잠깐! 음mm은 모바일 전용 App입니다.\n- Android 사용자 음mm 다운로드  https://play.google.com/store/apps/details?id=com.kakao.mmoa\n- iOS 사용자 음mm 다운로드  https://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#CQRS #백엔드 #MongoDB",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "2",
              "qnaStartTime": "15:00",
              "qnaEndTime": "16:00",
              "commentYn": "Y",
              "company": "카카오커머스",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4605,
                    "contentsIdx": 106,
                    "type": "FILE",
                    "fileSize": 5851587,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526621435",
                    "description": "Commerce Query data Rebuild Success 했을까.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4604,
                    "contentsIdx": 106,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596545",
                    "description": "15:14",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4603,
                    "contentsIdx": 106,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 99138,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418344125",
                    "description": "0913_카카오커머스_Noah.L.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4600,
                    "contentsIdx": 106,
                    "type": "PC_IMAGE",
                    "fileSize": 44657,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418369944",
                    "description": "0913_카카오커머스_Noah.L_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4601,
                    "contentsIdx": 106,
                    "type": "MO_IMAGE",
                    "fileSize": 25800,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418394165",
                    "description": "0913_카카오커머스_Noah.L_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4602,
                    "contentsIdx": 106,
                    "type": "SHARE_IMAGE",
                    "fileSize": 44657,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418405870",
                    "description": "0913_카카오커머스_Noah.L_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "백엔드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1457,
                  "contentsIdx": 106,
                  "nameKo": "이경렬",
                  "nameEn": "noah",
                  "company": "카카오커머스",
                  "occupation": "주문개발파트",
                  "loginEmail": "orth@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오커머스",
              "speakerName": "noah이경렬",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 107,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:39:07",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:06:45",
              "categoryIdx": 7,
              "title": "Webflux로 막힘없는 프로젝트 만들기",
              "content": "Webflux에서 Blocking I/O 사용 시 발생하는 문제에 대한 이해, 그리고 해결을 위한 툴과 노하우를 공유합니다.",
              "contentTag": "#백엔드 #Webflux",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "카카오뱅크",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3774,
                    "contentsIdx": 107,
                    "type": "FILE",
                    "fileSize": 4272533,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636524397590",
                    "description": "Webflux로 막힘없는 프로젝트 만들기_Spring Webflux 와 Blocking IO.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3773,
                    "contentsIdx": 107,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596552",
                    "description": "16:05",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3771,
                    "contentsIdx": 107,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 110032,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417696285",
                    "description": "0909_카카오뱅크_DY.ho.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 3772,
                    "contentsIdx": 107,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 112047,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417959348",
                    "description": "0909_카카오뱅크_Dan.1114.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3767,
                    "contentsIdx": 107,
                    "type": "PC_IMAGE",
                    "fileSize": 247118,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417917687",
                    "description": "0909_카카오뱅크_Dan.1114, DY.Ho_560.png",
                    "mainYn": "Y"
                  },
                  {
                    "idx": 3768,
                    "contentsIdx": 107,
                    "type": "PC_IMAGE",
                    "fileSize": 247118,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417964324",
                    "description": "0909_카카오뱅크_Dan.1114, DY.Ho_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3769,
                    "contentsIdx": 107,
                    "type": "MO_IMAGE",
                    "fileSize": 61720,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417908359",
                    "description": "0909_카카오뱅크_Dan.1114, DY.Ho_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3770,
                    "contentsIdx": 107,
                    "type": "SHARE_IMAGE",
                    "fileSize": 247118,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417926725",
                    "description": "0909_카카오뱅크_Dan.1114, DY.Ho_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "백엔드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1288,
                  "contentsIdx": 107,
                  "nameKo": "양호철",
                  "nameEn": "dy",
                  "company": "카카오뱅크",
                  "occupation": "서비스아키",
                  "loginEmail": "yh9589@gmail.com"
                },
                {
                  "idx": 1289,
                  "contentsIdx": 107,
                  "nameKo": "박종원",
                  "nameEn": "dan",
                  "company": "카카오뱅크",
                  "occupation": "뱅킹아키",
                  "loginEmail": "shrimpda@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오뱅크",
              "speakerName": "dy양호철",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 108,
              "createdUserIdx": 18,
              "createdDateTime": "2021-10-28 17:41:04",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:40:25",
              "categoryIdx": 7,
              "title": "DREAM BIG: large-scale로 문제 해결하기",
              "content": "large-scale data/models/computation을 사용해 문제를 해결하는 방법을 소개합니다.",
              "contentTag": "#머신러닝 #AI #딥러닝 #라지스케일",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "commentYn": "Y",
              "company": "카카오브레인",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 4171,
                    "contentsIdx": 108,
                    "type": "FILE",
                    "fileSize": 18556630,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636526387755",
                    "description": "Dream BIG_카카오브레인에서 접근하고 있는 Large-Scale 문제 해결.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4170,
                    "contentsIdx": 108,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596567",
                    "description": "12:38",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4169,
                    "contentsIdx": 108,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 118026,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417622323",
                    "description": "0909_카카오브레인_Clint.B.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4166,
                    "contentsIdx": 108,
                    "type": "PC_IMAGE",
                    "fileSize": 68999,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417644396",
                    "description": "0909_카카오브레인_Clint.B_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4167,
                    "contentsIdx": 108,
                    "type": "MO_IMAGE",
                    "fileSize": 32578,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417651111",
                    "description": "0909_카카오브레인_Clint.B_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4168,
                    "contentsIdx": 108,
                    "type": "SHARE_IMAGE",
                    "fileSize": 68999,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417634656",
                    "description": "0909_카카오브레인_Clint.B_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "머신러닝/AI"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1367,
                  "contentsIdx": 108,
                  "nameKo": "백운혁",
                  "nameEn": "clint",
                  "company": "카카오브레인",
                  "occupation": "Large-Scale 팀",
                  "loginEmail": "bwhyuk@daum.net"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오브레인",
              "speakerName": "clint백운혁",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 109,
              "createdUserIdx": 17,
              "createdDateTime": "2021-10-28 17:43:45",
              "lastModifiedUserIdx": 18,
              "lastModifiedDateTime": "2021-11-10 15:32:02",
              "categoryIdx": 7,
              "title": "은행 전체계좌조회 API Renewal. 오슬로",
              "content": "카카오뱅크 모바일앱에 제공되는 주요 조회 API들을, 뒷단의 비즈니스 백엔드 시스템으로 보내지 않고, 데이터 복제를 통해 자체 구현 로직으로 처리하는 오슬로 시스템을 구현한 경험에 대해 공유합니다. ",
              "contentTag": "#은행전체계좌조회API #조회전용시스템 #캐싱 #데이터복제",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "12:00",
              "qnaEndTime": "13:00",
              "commentYn": "Y",
              "company": "카카오뱅크",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3988,
                    "contentsIdx": 109,
                    "type": "FILE",
                    "fileSize": 1396738,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525921817",
                    "description": "은행 전체계좌조회API Renewal. 오슬로._계정계부터 오픈소스 백엔드까지 완결적으로 개발하기.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3987,
                    "contentsIdx": 109,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596554",
                    "description": "19:54",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3986,
                    "contentsIdx": 109,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 101138,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418247507",
                    "description": "0909_카카오뱅크_Kenny.K.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3983,
                    "contentsIdx": 109,
                    "type": "PC_IMAGE",
                    "fileSize": 70664,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418268856",
                    "description": "0909_카카오뱅크_Kenny.K_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3984,
                    "contentsIdx": 109,
                    "type": "MO_IMAGE",
                    "fileSize": 33023,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418281151",
                    "description": "0909_카카오뱅크_Kenny.K_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3985,
                    "contentsIdx": 109,
                    "type": "SHARE_IMAGE",
                    "fileSize": 70664,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635418292060",
                    "description": "0909_카카오뱅크_Kenny.K_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "백엔드"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1329,
                  "contentsIdx": 109,
                  "nameKo": "고동균",
                  "nameEn": "kenny",
                  "company": "카카오뱅크",
                  "occupation": "뱅킹API개발팀",
                  "loginEmail": "itskooh@gmail.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오뱅크",
              "speakerName": "kenny고동균",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 133,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 20:49:39",
              "lastModifiedUserIdx": 17,
              "lastModifiedDateTime": "2021-11-10 15:27:08",
              "categoryIdx": 7,
              "title": "Klaytn 블록체인 데이터 추출하기",
              "content": "블록체인 데이터를 추출하면서 생겼던 문제점과 이를 어떻게 개선했는지에 대한 경험을 공유합니다.",
              "contentTag": "#블록체인 #Klaytn #데이터스트리밍",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "B Type",
              "qnaStartDay": "3",
              "qnaStartTime": "14:00",
              "qnaEndTime": "15:00",
              "commentYn": "Y",
              "company": "그라운드X",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  {
                    "idx": 3958,
                    "contentsIdx": 133,
                    "type": "FILE",
                    "fileSize": 380953,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1636525616863",
                    "description": "Klaytn 블록체인 데이터 추출하기.pdf",
                    "mainYn": "N"
                  }
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3957,
                    "contentsIdx": 133,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://tv.kakao.com/embed/player/cliplink/423596008",
                    "description": "17:20",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3956,
                    "contentsIdx": 133,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 102870,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635421714831",
                    "description": "0831_그라운드X_JK.Oh.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3953,
                    "contentsIdx": 133,
                    "type": "PC_IMAGE",
                    "fileSize": 58923,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635421734470",
                    "description": "0831_그라운드X_JK.Oh_560.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3954,
                    "contentsIdx": 133,
                    "type": "MO_IMAGE",
                    "fileSize": 27942,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635421776554",
                    "description": "0831_그라운드X_JK.Oh_236.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3955,
                    "contentsIdx": 133,
                    "type": "SHARE_IMAGE",
                    "fileSize": 58923,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635421740780",
                    "description": "0831_그라운드X_JK.Oh_560.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "블록체인"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1324,
                  "contentsIdx": 133,
                  "nameKo": "오정균",
                  "nameEn": "jk",
                  "company": "그라운드X",
                  "occupation": "블록체인 플랫폼 개발팀",
                  "loginEmail": "lasking88@kakao.com"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "그라운드X",
              "speakerName": "jk오정균",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 122,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 19:32:58",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-11 17:12:06",
              "categoryIdx": 7,
              "title": "카카오 애자일 상담소 (2일차)",
              "content": "카카오에서 일하는 방식이 궁금하신가요? \n제품, 조직 관점에서 일하는 방식의 변화를 이끌어 가는 과정에서 고민이 있으신가요?\n아니면, 카카오의 애자일코치는 어떤 사람들인지 궁금하신가요?\n\n그렇다면 카카오 애자일 상담소를 찾아주세요.\nif(kakao) 2021 콘퍼런스가 진행되는 3일동안 매일 오후 2시부터 3시까지 카카오의 애자일코치 세명과 함께 이야기를 나눌 수 있습니다.\n궁금하신 내용은 미리 사전 질문 링크를 통해 남겨주시면 라이브 진행시 답변을 드릴 예정입니다.\n물론, 라이브 진행시 손👋을 들어 직접 음성으로 대화를 나눌 수도 있어요.\n\n2일차 : 더 나은 제품(서비스)을 만드는 과정에서 어려움을 겪고 있다면?\n- 사전질문 : https://app.sli.do/event/1jnbtric\n\n3일차 : 1~2일차 주요 내용 요약 및 자유주제\n- 세션 : https://if.kakao.com/session/live/123\n\n* 카카오 애자일상담소는 소셜 오디오 플랫폼 ‘음mm’ 에서 라이브로 진행됩니다.\n- Android 사용자 음mm 다운로드 \nhttps://play.google.com/store/apps/details?id=com.kakao.mmoa\n- iOS 사용자 음mm 다운로드 \nhttps://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#애자일 #애자일코칭 #성장 #협업 #커뮤니케이션 #함께성장하기 #일하는방식",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "Live",
              "commentYn": "N",
              "company": "카카오",
              "reservationDate": "20211117",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 4301,
                    "contentsIdx": 122,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://www.mm.xyz/event/acca6f7f-e361-4b53-b592-6d0f7b910da9",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 4298,
                    "contentsIdx": 122,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 94883,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635745013537",
                    "description": "0914_카카오_Bella.Coach.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 4299,
                    "contentsIdx": 122,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 103173,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635745016920",
                    "description": "프로필_benedict.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 4300,
                    "contentsIdx": 122,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 119564,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635745021295",
                    "description": "프로필_jazz.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 4295,
                    "contentsIdx": 122,
                    "type": "PC_IMAGE",
                    "fileSize": 456951,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417050077",
                    "description": "day2_상세페이지_pc.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 4296,
                    "contentsIdx": 122,
                    "type": "MO_IMAGE",
                    "fileSize": 41209,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417067428",
                    "description": "day2_상세페이지_mo.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 4297,
                    "contentsIdx": 122,
                    "type": "SHARE_IMAGE",
                    "fileSize": 456951,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417054941",
                    "description": "day2_상세페이지_pc.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "개발문화",
                  "기타"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1391,
                  "contentsIdx": 122,
                  "nameKo": "백미진",
                  "nameEn": "bella",
                  "company": "카카오",
                  "occupation": "애자일코치"
                },
                {
                  "idx": 1392,
                  "contentsIdx": 122,
                  "nameKo": "이호정",
                  "nameEn": "benedict",
                  "company": "카카오",
                  "occupation": "애자일코치"
                },
                {
                  "idx": 1393,
                  "contentsIdx": 122,
                  "nameKo": "김지훈",
                  "nameEn": "jazz",
                  "company": "카카오",
                  "occupation": "애자일코치"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오",
              "speakerName": "bella백미진",
              "speakerLoginYn": "N",
              "reservationUTC": 1637078400000,
              "reservationYn": "Y",
              "videoYn": "Y"
            },
            {
              "idx": 123,
              "createdUserIdx": 16,
              "createdDateTime": "2021-10-28 19:36:30",
              "lastModifiedUserIdx": 16,
              "lastModifiedDateTime": "2021-11-05 17:45:43",
              "categoryIdx": 8,
              "title": "카카오 애자일 상담소 (3일차)",
              "content": "카카오에서 일하는 방식이 궁금하신가요? \n제품, 조직 관점에서 일하는 방식의 변화를 이끌어 가는 과정에서 고민이 있으신가요?\n아니면, 카카오의 애자일코치는 어떤 사람들인지 궁금하신가요?\n\n그렇다면 카카오 애자일 상담소를 찾아주세요.\nif(kakao) 2021 콘퍼런스가 진행되는 3일동안 매일 오후 2시부터 3시까지 카카오의 애자일코치 세명과 함께 이야기를 나눌 수 있습니다.\n궁금하신 내용은 미리 사전 질문 링크를 통해 남겨주시면 라이브 진행시 답변을 드릴 예정입니다.\n물론, 라이브 진행시 손👋을 들어 직접 음성으로 대화를 나눌 수도 있어요.\n\n3일차 : 1~2일차 주요 내용 요약 및 자유주제\n- 사전질문 : https://app.sli.do/event/7sokjytj\n\n* 카카오 애자일상담소는 소셜 오디오 플랫폼 ‘음mm’ 에서 라이브로 진행됩니다.\n- Android 사용자 음mm 다운로드 \nhttps://play.google.com/store/apps/details?id=com.kakao.mmoa\n- iOS 사용자 음mm 다운로드 \nhttps://apps.apple.com/kr/app/id1567177871",
              "contentTag": "#애자일 #애자일코칭 #성장 #협업 #커뮤니케이션 #함께성장하기 #일하는방식",
              "spotlightYn": "N",
              "field": "기술",
              "sessionType": "Live",
              "commentYn": "N",
              "company": "카카오",
              "reservationDate": "20211118",
              "reservationTime": "1000",
              "linkList": {
                "FILE": [
                  
                ],
                "IMAGE": [
                  
                ],
                "WEB_URL": [
                  
                ],
                "VIDEO": [
                  {
                    "idx": 3351,
                    "contentsIdx": 123,
                    "type": "VIDEO",
                    "fileSize": 0,
                    "url": "https://www.mm.xyz/event/8293328d-6eb0-49e7-9682-afef26ecd90a",
                    "mainYn": "N"
                  }
                ],
                "PC_THUMBNAIL": [
                  
                ],
                "MO_THUMBNAIL": [
                  
                ],
                "TALK_THUMBNAIL": [
                  
                ],
                "SPEAKER_PROFILE": [
                  {
                    "idx": 3348,
                    "contentsIdx": 123,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 94883,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635744838850",
                    "description": "0914_카카오_Bella.Coach.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 3349,
                    "contentsIdx": 123,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 103173,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635744842681",
                    "description": "프로필_benedict.png",
                    "mainYn": "N"
                  },
                  {
                    "idx": 3350,
                    "contentsIdx": 123,
                    "type": "SPEAKER_PROFILE",
                    "fileSize": 119564,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635744847318",
                    "description": "프로필_jazz.png",
                    "mainYn": "N"
                  }
                ],
                "PC_MAIN_IMAGE": [
                  
                ],
                "MO_MAIN_IMAGE": [
                  
                ],
                "PC_IMAGE": [
                  {
                    "idx": 3345,
                    "contentsIdx": 123,
                    "type": "PC_IMAGE",
                    "fileSize": 456488,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417366233",
                    "description": "day3_상세페이지_pc.png",
                    "mainYn": "Y"
                  }
                ],
                "MO_IMAGE": [
                  {
                    "idx": 3346,
                    "contentsIdx": 123,
                    "type": "MO_IMAGE",
                    "fileSize": 40349,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417380197",
                    "description": "day3_상세페이지_mo.png",
                    "mainYn": "N"
                  }
                ],
                "SHARE_IMAGE": [
                  {
                    "idx": 3347,
                    "contentsIdx": 123,
                    "type": "SHARE_IMAGE",
                    "fileSize": 456488,
                    "url": "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1635417370786",
                    "description": "day3_상세페이지_pc.png",
                    "mainYn": "N"
                  }
                ],
                "PC_SPOTLIGHT": [
                  
                ],
                "MO_SPOTLIGHT": [
                  
                ]
              },
              "relationList": {
                "CLASSIFICATION": [
                  
                ],
                "TECH_CLASSIFICATION": [
                  "개발문화",
                  "기타"
                ],
                "MAIN_EXPOSURE_DAY": [
                  
                ]
              },
              "contentsSpeakerList": [
                {
                  "idx": 1188,
                  "contentsIdx": 123,
                  "nameKo": "백미진",
                  "nameEn": "bella",
                  "company": "카카오",
                  "occupation": "애자일코치"
                },
                {
                  "idx": 1189,
                  "contentsIdx": 123,
                  "nameKo": "이호정",
                  "nameEn": "benedict",
                  "company": "카카오",
                  "occupation": "애자일코치"
                },
                {
                  "idx": 1190,
                  "contentsIdx": 123,
                  "nameKo": "김지훈",
                  "nameEn": "jazz",
                  "company": "카카오",
                  "occupation": "애자일코치"
                }
              ],
              "favoriteYn": "N",
              "newCountentsYn": "N",
              "updateCountentsYn": "N",
              "companyName": "카카오",
              "speakerName": "bella백미진",
              "speakerLoginYn": "N",
              "reservationUTC": 1637164800000,
              "reservationYn": "Y",
              "videoYn": "Y"
            }
          ],
          "count": 27,
          "errorMessage": null
        }
    """.trimIndent()
    private val response: IfKakaoResponse =
        Gson().fromJson(jsonResponse, IfKakaoResponse::class.java)

    private var sessions = response.data?.convert()

    override suspend fun getAllSessions(): List<Session> {
        return sessions ?: listOf()
    }
}