package resources

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

object Carousel {

    private val listBariloche = mutableListOf<CarouselItem>()
    fun setImagesCarouselListBariloche(){

        listBariloche.add(CarouselItem("https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Llao_llao.jpg/800px-Llao_llao.jpg"))
        listBariloche.add(CarouselItem("https://media.cdn.laarena.com.ar/042022/1651019322117.webp?cw=750&ch=420&extw=jpg"))
        listBariloche.add(CarouselItem("https://media.istockphoto.com/id/1371183753/es/foto/bariloche-ar-vista-desde-arriba-un-paisaje-encantador.jpg?s=612x612&w=0&k=20&c=CfSIcfNLlXooy1XRtLOqGEaSD1ggWkSdrg22HK0itEQ="))
        listBariloche.add(CarouselItem("https://cdn.pixabay.com/photo/2020/05/06/16/19/dawn-5138173_1280.jpg"))
        listBariloche.add(CarouselItem("https://cdn.pixabay.com/photo/2020/02/28/21/16/route-4888644_1280.jpg"))

    }
    fun runCarousel (PackageId: Long): List<CarouselItem>{
        var listReturn = mutableListOf<CarouselItem>()
        when(PackageId) {
            1L -> {
                setImagesCarouselListBariloche()
                listReturn = listBariloche.toMutableList()
            }
        }
        return listReturn
    }

}