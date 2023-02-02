FILESEXTRAPATHS:append := "${THISDIR}/files:"

inherit obmc-phosphor-systemd
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

S = "${WORKDIR}"

SRC_URI = "file://setup_gpio.sh \
           file://host-gpio.service \
           file://networkd_reload.sh \
           file://fix_get_dhcp_ip.service \
"

DEPENDS = "systemd"
RDEPENDS:${PN} = "libgpiod-tools"
RDEPENDS:${PN} = "bash"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "host-gpio.service fix_get_dhcp_ip.service"

do_install() {
    install -d ${D}/usr/sbin
    install -m 0755 ${S}/setup_gpio.sh ${D}/${sbindir}/
    install -m 0755 ${S}/networkd_reload.sh ${D}/${sbindir}/
}
