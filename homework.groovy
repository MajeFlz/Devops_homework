node {
    def infoDisk = sh(returnStdout: true, script: "df -h").trim()

    echo "Состояние диска:"
    echo infoDisk
}
