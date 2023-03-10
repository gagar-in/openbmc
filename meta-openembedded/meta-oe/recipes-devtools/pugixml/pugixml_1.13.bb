SUMMARY = "Light-weight C++ XML Processing Library"
DESCRIPTION = "pugixml is a C++ XML processing library, which consists of a \
DOM-like interface with rich traversal/modification capabilities, \
an extremely fast XML parser which constructs the DOM tree from \
n XML file/buffer, and an XPath 1.0 implementation for complex \
data-driven tree queries."
HOMEPAGE = "https://pugixml.org/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;beginline=29;endline=52;md5=d11b640daff611273752ec136394347c"

SRC_URI = "https://github.com/zeux/${BPN}/releases/download/v${PV}/${BP}.tar.gz"
SRC_URI[sha256sum] = "40c0b3914ec131485640fa57e55bf1136446026b41db91c1bef678186a12abbe"

UPSTREAM_CHECK_URI = "https://github.com/zeux/${BPN}/releases"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_PKGCONFIG=ON \
                  -DBUILD_SHARED_LIBS=ON \
                  -DCMAKE_BUILD_TYPE=Release \
                  "

BBCLASSEXTEND = "native nativesdk"
