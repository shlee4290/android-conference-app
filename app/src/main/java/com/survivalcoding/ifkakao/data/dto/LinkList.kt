package com.survivalcoding.ifkakao.data.dto

data class LinkList(
    val FILE: List<Link>? = null,
    val IMAGE: List<Link>? = null,
    val MO_IMAGE: List<Link>? = null,
    val MO_MAIN_IMAGE: List<Link>? = null,
    val MO_SPOTLIGHT: List<Link>? = null,
    val MO_THUMBNAIL: List<Link>? = null,
    val PC_IMAGE: List<Link>? = null,
    val PC_MAIN_IMAGE: List<Link>? = null,
    val PC_SPOTLIGHT: List<Link>? = null,
    val PC_THUMBNAIL: List<Link>? = null,
    val SHARE_IMAGE: List<Link>? = null,
    val SPEAKER_PROFILE: List<Link>? = null,
    val TALK_THUMBNAIL: List<Link>? = null,
    val VIDEO: List<Link>? = null,
    val WEB_URL: List<Link>? = null
)