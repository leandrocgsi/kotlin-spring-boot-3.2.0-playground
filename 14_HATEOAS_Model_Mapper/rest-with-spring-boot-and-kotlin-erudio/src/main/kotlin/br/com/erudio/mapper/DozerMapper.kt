package br.com.erudio.mapper

import br.com.erudio.data.vo.v1.PersonVO
import br.com.erudio.model.Person
import org.modelmapper.ModelMapper
import java.awt.print.Book
import javax.print.attribute.standard.Destination



object DozerMapper {

    val mapper: ModelMapper = ModelMapper()

    init {
        mapper.createTypeMap<Person, PersonVO>(
            Person::class.java,
            PersonVO::class.java
        )
        .addMapping<Long>(Person::id, PersonVO::key)

        mapper.createTypeMap<PersonVO, Person>(
            PersonVO::class.java,
            Person::class.java
        )
        .addMapping<Long>(PersonVO::key, Person::id)

    }

    fun <O,D> parseObject(origin: O, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    fun <O,D> parseListObjects(origin: List<O>, destination: Class<D>?): ArrayList<D> {
        val destinationObjects: ArrayList<D> = ArrayList()
        for(o in origin) {
            destinationObjects.add(mapper.map(o, destination))
        }
        return destinationObjects
    }
}