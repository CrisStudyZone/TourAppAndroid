package com.example.tourapp.resources

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

object Carousel {

    private val listBariloche = mutableListOf<CarouselItem>()
    private val listMendoza = mutableListOf<CarouselItem>()
    private val listMerlo = mutableListOf<CarouselItem>()
    private val listTermas = mutableListOf<CarouselItem>()
    private val listCuartetazo = mutableListOf<CarouselItem>()
    private val listNaturaleza = mutableListOf<CarouselItem>()
    private val listFinDelMundo = mutableListOf<CarouselItem>()
    private val listNorte = mutableListOf<CarouselItem>()
    private val listUruguay = mutableListOf<CarouselItem>()
    private val listCataratas = mutableListOf<CarouselItem>()

    private val imageCache = mutableMapOf<Long, MutableList<CarouselItem>>()

    fun setImagesCarouselListBariloche(){

        listBariloche.add(CarouselItem("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Llao_llao.jpg/800px-Llao_llao.jpg"))
        listBariloche.add(CarouselItem("https://media.cdn.laarena.com.ar/042022/1651019322117.webp?cw=750&ch=420&extw=jpg"))
        listBariloche.add(CarouselItem("https://media.istockphoto.com/id/1371183753/es/foto/bariloche-ar-vista-desde-arriba-un-paisaje-encantador.jpg?s=612x612&w=0&k=20&c=CfSIcfNLlXooy1XRtLOqGEaSD1ggWkSdrg22HK0itEQ="))
        listBariloche.add(CarouselItem("https://cdn.pixabay.com/photo/2020/05/06/16/19/dawn-5138173_1280.jpg"))
        listBariloche.add(CarouselItem("https://cdn.pixabay.com/photo/2020/02/28/21/16/route-4888644_1280.jpg"))

    }
    fun setImagesCarouselListMendoza(){

        listMendoza.add(CarouselItem("https://d3lm2uu0kvu7y7.cloudfront.net/uploads/2021/12/image61c5e0fbb283f.jpg"))
        listMendoza.add(CarouselItem("https://d3lm2uu0kvu7y7.cloudfront.net/uploads/2021/04/image60747799596ad.jpg"))
        listMendoza.add(CarouselItem("https://d3lm2uu0kvu7y7.cloudfront.net/uploads/2017/01/image588400cc7a17d.jpg"))
        listMendoza.add(CarouselItem("https://tangol.com/blog/Fotos/Notas/lanzate-tirolesa-en-mendoza_398_202102231623570.JPG"))
        listMendoza.add(CarouselItem("https://scontent.faep8-3.fna.fbcdn.net/v/t1.6435-9/92342947_3036580036403429_1690260241624596480_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=7f8c78&_nc_ohc=QAUmBhqZrPMAX-wb0Q2&_nc_ht=scontent.faep8-3.fna&oh=00_AfALCjyp_1q2Tq78JWDJiIDzy6V6j3wd6DZnKlM0twPOlg&oe=657AC4F9"))

    }
    fun setImagesCarouselListMerlo(){

        listMerlo.add(CarouselItem("https://cloudfront-us-east-1.images.arcpublishing.com/artear/C5DNOQH6TJBMJGIPWB2HU4QCNQ.jpeg"))
        listMerlo.add(CarouselItem("https://www.tangol.com/blog/Fotos/naturaleza-y-descanso-en-la-villa-de-merlo_151_201607061144170.JPG"))
        listMerlo.add(CarouselItem("https://images.sparairnos.com/property/16838/images/78797/full/033745b3-4493-4865-ba02-609f051ce482"))
        listMerlo.add(CarouselItem("https://images.sparairnos.com/property/16838/images/78797/full/a96f1a00-6ba6-4c7e-822f-fe133ec0b928"))
        listMerlo.add(CarouselItem("https://elterritorio1.cdn.net.ar/252/elterritorio1/images/43/21/432189_f6681f45431c41082a67641674245eb136f5a47f3bf03b669b9f1bbb1bc034fc/lg.jpg"))

    }

    fun setImagesCarouselListTermas(){

        listTermas.add(CarouselItem("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/e9/14/69/termas-colon-sector-norte.jpg?w=1200&h=-1&s=1"))
        listTermas.add(CarouselItem("https://www.plataforma10.com.ar/viajes/wp-content/uploads/2023/06/termas.webp"))
        listTermas.add(CarouselItem("https://www.plataforma10.com.ar/viajes/wp-content/uploads/2023/06/piscina.webp"))
        listTermas.add(CarouselItem("https://www.plataforma10.com.ar/viajes/wp-content/uploads/2023/06/playa-colon-1024x579.webp"))
        listTermas.add(CarouselItem("https://www.plataforma10.com.ar/viajes/wp-content/uploads/2023/06/parque-acuatico.webp"))

    }
    fun setImagesCarouselListCordoba(){

        listCuartetazo.add(CarouselItem("https://www.cordobaturismo.gov.ar/wp-content/uploads/2020/10/R%C3%ADo-en-La-Cumbrecita.jpg"))
        listCuartetazo.add(CarouselItem("https://www.lacumbrecita.gob.ar/images/rincones/olla-04.jpg"))
        listCuartetazo.add(CarouselItem("https://www.cadena3.com/admin/playerswf/fotos/ARCHI_730822.jpg"))
        listCuartetazo.add(CarouselItem("https://www.cadena3.com/admin/playerswf/fotos/ARCHI_616797.jpg"))
        listCuartetazo.add(CarouselItem("https://www.welcomeargentina.com/paseos/excursion_cumbrecita/la-cumbrecita-1.jpg"))

    }
    fun setImagesCarouselListCorrientes(){

        listNaturaleza.add(CarouselItem("https://www.corrienteshoy.com/galeria/fotos/2020/11/05/l_1604587913.jpg"))
        listNaturaleza.add(CarouselItem("https://www.corrientes.com.ar/util/img/esteros-del-ibera-3.jpg"))
        listNaturaleza.add(CarouselItem("https://pxc.cdn.ellitoral.com.ar/litoral/012020/1579403690965.webp?cw=770&ch=440&extw=jpg"))
        listNaturaleza.add(CarouselItem("https://www.voydeviaje.com.ar/resizer/cpdcwXapp7bSOlY47lEyliwM2Q0=/980x640/smart/filters:quality(75):format(webp)/cloudfront-us-east-1.images.arcpublishing.com/grupoclarin/SACLNCJ7IVH63AEDKDYTMG3RKA.jpg"))
        listNaturaleza.add(CarouselItem("https://www.voydeviaje.com.ar/resizer/VfEr5BZvIIos1KNXnE7N4DD8G4E=/1023x683/smart/cloudfront-us-east-1.images.arcpublishing.com/grupoclarin/EKXRJR6WBJBATBPAJ5K6J5W2GI.jpg"))

    }
    fun setImagesCarouselListUshuaia(){

        listFinDelMundo.add(CarouselItem("https://upload.wikimedia.org/wikipedia/commons/7/71/Les_Eclaireurs_Lighthouse.jpg"))
        listFinDelMundo.add(CarouselItem("https://www.costacruceros.com/content/dam/costa/costa-magazine/article-images/what-to-see-in-ushaia/ushuaia.jpg.image.1296.974.high.jpg"))
        listFinDelMundo.add(CarouselItem("https://www.costacruceros.com/content/dam/costa/costa-magazine/article-images/what-to-see-in-ushaia/torres-del-paine.jpg.image.1296.974.high.jpg"))
        listFinDelMundo.add(CarouselItem("https://www.costacruceros.com/content/dam/costa/costa-magazine/article-images/what-to-see-in-ushaia/parco-nazionale-terra-del-fuoco.jpg.image.1296.974.high.jpg"))
        listFinDelMundo.add(CarouselItem("https://www.costacruceros.com/content/dam/costa/costa-magazine/article-images/what-to-see-in-ushaia/ghiacciaio-perito-moreno.jpg.image.1296.974.high.jpg"))

    }
    fun setImagesCarouselListSalta(){

        listNorte.add(CarouselItem("https://eqfsewpc7rt.exactdn.com/wp-content/uploads/2022/01/que-ahcer-en-salta-dia-por-dia.jpeg?lossy=1&ssl=1"))
        listNorte.add(CarouselItem("https://voyasalta.com.ar/wp-content/uploads/2023/04/viajar-1.jpg"))
        listNorte.add(CarouselItem("https://valenciaplaza.com/public/Image/2018/9/Capturadepantalla2018-09-10alas16.48.54.png_NoticiaAmpliada.jpg"))
        listNorte.add(CarouselItem("https://universes.art/fileadmin/_processed_/f/7/csm_00-P1030492-2000-750_6587371537.jpg"))
        listNorte.add(CarouselItem("https://i2.wp.com/fueradeeje.com/wp-content/uploads/2020/06/DESTINOS-M%C3%81S-VISITADOS-DE-SALTA-05.jpg?resize=1200%2C800&ssl=1"))

    }
    fun setImagesCarouselListUruguay(){

        listUruguay.add(CarouselItem("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Colonia_del_Sacramento_calle_t%C3%ADpica.JPG/640px-Colonia_del_Sacramento_calle_t%C3%ADpica.JPG"))
        listUruguay.add(CarouselItem("https://media.ambito.com/p/4e6efb745067673caab0aec301293984/adjuntos/239/imagenes/040/295/0040295755/655x368/smart/foto-colonia-destacadajpg.jpg"))
        listUruguay.add(CarouselItem("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0b/96/4c/c9/colonia-del-sacramento.jpg?w=1400&h=-1&s=1"))
        listUruguay.add(CarouselItem("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/17/81/27/8a/plaza-de-toros-colonia.jpg?w=1100&h=-1&s=1"))
        listUruguay.add(CarouselItem("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/19/f6/05/68/asados-en-fogon-exterior.jpg?w=1400&h=-1&s=1"))

    }
    fun setImagesCarouselListCataratas(){

        listCataratas.add(CarouselItem("https://www.alas2017.com/wp-content/uploads/2017/09/cataratas.png"))
        listCataratas.add(CarouselItem("https://media.traveler.es/photos/613768f04c612f07ec398ef9/master/w_1600,c_limit/158844.jpg"))
        listCataratas.add(CarouselItem("https://media.traveler.es/photos/613768f03decec3303bab7db/master/w_1600,c_limit/158845.jpg"))
        listCataratas.add(CarouselItem("https://media.traveler.es/photos/613768f068a6ada2592a6c1e/master/w_1600,c_limit/158847.jpg"))
        listCataratas.add(CarouselItem("https://media.traveler.es/photos/613768f0d7c7024f9175e567/master/w_1600,c_limit/158846.jpg"))

    }

    fun runCarousel (PackageId: Long): List<CarouselItem>{
        //Verificamos si las imagenes ya estan cargadas en el cache
        if (imageCache.containsKey(PackageId)){
            return imageCache[PackageId] ?: emptyList()
        }
        var listReturn = mutableListOf<CarouselItem>()
        when(PackageId) {
            1L -> {
                setImagesCarouselListBariloche()
                listReturn = listBariloche.toMutableList()
            }
            2L -> {
                setImagesCarouselListMendoza()
                listReturn = listMendoza.toMutableList()
            }
            3L -> {
                setImagesCarouselListMerlo()
                listReturn = listMerlo.toMutableList()
            }
            4L -> {
                setImagesCarouselListTermas()
                listReturn = listTermas.toMutableList()
            }
            5L -> {
                setImagesCarouselListCordoba()
                listReturn = listCuartetazo.toMutableList()
            }
            6L -> {
                setImagesCarouselListCorrientes()
                listReturn = listNaturaleza.toMutableList()
            }
            7L -> {
                setImagesCarouselListUshuaia()
                listReturn = listFinDelMundo.toMutableList()
            }
            8L -> {
                setImagesCarouselListSalta()
                listReturn = listNorte.toMutableList()
            }
            9L -> {
                setImagesCarouselListUruguay()
                listReturn = listUruguay.toMutableList()
            }
            10L -> {
                setImagesCarouselListCataratas()
                listReturn = listCataratas.toMutableList()
            }
            else -> emptyList<CarouselItem>()
        }
        //Cargamos las imagenes al chache para que no se vuelvan a descargar
        imageCache[PackageId] = listReturn.toMutableList()
        return listReturn
    }

}