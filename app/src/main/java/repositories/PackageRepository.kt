package repositories

import android.os.Build
import androidx.annotation.RequiresApi
import data.TourPackage
import model.AirPlane
import model.Bus
import model.Ferry
import model.Train
import java.time.LocalDate
import java.time.LocalTime

@RequiresApi(Build.VERSION_CODES.O)
object PackageRepository {

    private val packages = mutableListOf<TourPackage>()

    init {
        packages.add(
            TourPackage(
                1L,
                "Bariloche Premium",
                Bus(),
                10,
                4.7,
                150000.00,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Llao_llao.jpg/800px-Llao_llao.jpg",
                //gs://importtourappprueba3.appspot.com/Bariloche Premium
                DestinationRepository.getBariloche()
            )
        )

        packages.add(
            TourPackage(
                2L,
                "Mendoza Extremo",
                Bus(),
                7,
                4.1,
                75000.50,
                "https://tangol.com/blog/Fotos/Notas/lanzate-tirolesa-en-mendoza_398_202102231623570.JPG",
                //gs://importtourappprueba3.appspot.com/Mendoza Extremo
                DestinationRepository.getMendoza()
            )
        )

        packages.add(
            TourPackage(
                3L,
                "Descanso en Merlo",
                Bus(),
                5,
                3.6,
                55000.50,
                "https://cloudfront-us-east-1.images.arcpublishing.com/artear/C5DNOQH6TJBMJGIPWB2HU4QCNQ.jpeg",
                //gs://importtourappprueba3.appspot.com/Descanso en Merlo
                DestinationRepository.getMerlo()
            )
        )

        packages.add(
            TourPackage(
                4L,
                "Full termas",
                Bus(),
                4,
                4.0,
                35500.75,
                "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/e9/14/69/termas-colon-sector-norte.jpg?w=1200&h=-1&s=1",
                //gs://importtourappprueba3.appspot.com/Full termas
                DestinationRepository.getTermas()
            )
        )

        packages.add(
            TourPackage(
                5L,
                "Cuartetazo",
                Train(LocalDate.now()),
                6,
                4.9,
                84000.00,
                "https://www.cordobaturismo.gov.ar/wp-content/uploads/2020/10/R%C3%ADo-en-La-Cumbrecita.jpg",
                //gs://importtourappprueba3.appspot.com/Cuartetazo
                DestinationRepository.getCordoba()
            )
        )

        packages.add(
            TourPackage(
                6L,
                "Vibra la naturaleza",
                Bus(),
                7,
                5.0,
                150000.00,
                "https://www.corrientes.com.ar/util/img/esteros-del-ibera-3.jpg",
                //gs://importtourappprueba3.appspot.com/Vibra la naturaleza
                DestinationRepository.getEsterosDelIbera()
            )
        )

        packages.add(
            TourPackage(
                7L,
                "Fin del mundo",
                AirPlane(LocalTime.now()),
                5,
                4.8,
                415000.00,
                "https://upload.wikimedia.org/wikipedia/commons/7/71/Les_Eclaireurs_Lighthouse.jpg",
                //gs://importtourappprueba3.appspot.com/Fin del mundo
                DestinationRepository.getUshuaia()
            )
        )

        packages.add(
            TourPackage(
                8L,
                "Nos vamos para el norte!",
                AirPlane(LocalTime.now()),
                5,
                3.9,
                120000.00,
                "https://universes.art/fileadmin/_processed_/f/7/csm_00-P1030492-2000-750_6587371537.jpg",
                //gs://importtourappprueba3.appspot.com/Nos vamos para el norte!
                DestinationRepository.getSalta()
            )
        )

        packages.add(
            TourPackage(
                9L,
                "Cruzando el charco",
                Ferry(),
                3,
                1.7,
                45000.75,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Colonia_del_Sacramento_calle_t%C3%ADpica.JPG/640px-Colonia_del_Sacramento_calle_t%C3%ADpica.JPG",
                //gs://importtourappprueba3.appspot.com/Cruzando el charco
                DestinationRepository.getColonia()
            )
        )

        packages.add(
            TourPackage(
                10L,
                "Full Cataratas",
                AirPlane(LocalTime.now()),
                6,
                4.9,
                85000.00,
                "https://www.alas2017.com/wp-content/uploads/2017/09/cataratas.png",
                //gs://importtourappprueba3.appspot.com/Full Cataratas
                DestinationRepository.getCataratas()
            )
        )

    }

    fun get() : List<TourPackage> {

        return packages
    }

    fun getById(id: Long): TourPackage? {
        return packages.find { it.id == id }
    }

}