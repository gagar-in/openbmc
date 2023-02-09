FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
         file://${MACHINE}.cfg \
         file://0001-change-flash-mem-dtsi-for-64M.patch \
         file://0002-reserv-memory-for-video.patch \
         file://0003-add-uart-setting-for-SOL.patch \
         file://0004-enable-kcs4.patch \
         file://0005-enable-vhub.patch \
         file://0006-add-led-support-into-dts.patch \
         file://0007-add-peci0-support-into-dts.patch \
"