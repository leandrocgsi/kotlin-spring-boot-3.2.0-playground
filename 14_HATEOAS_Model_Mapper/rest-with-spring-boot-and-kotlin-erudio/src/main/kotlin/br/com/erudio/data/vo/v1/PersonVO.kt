package br.com.erudio.data.vo.v1

import org.springframework.hateoas.RepresentationModel

data class PersonVO (

    var key: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
) : RepresentationModel<PersonVO>()