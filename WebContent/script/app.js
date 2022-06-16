const log = console.log;


//페이지 네이션을 구현할 생각이었지만 php에서 구현함
class App {
    constructor() {
        this.init();
    }

    init() {
        document.querySelectorAll(".pagination a").forEach(elem => {
            elem.addEventListener("click", e => {
                let href = elem.href;
                this.reload(this.send(href));

                e.preventDefault(); //중단
            })
        })
    }

    async reload(xml) {
        try {
            var data = await xml;
        } catch (error) {
            log(error);
        }

        let html = document.createElement("html");
        html.innerHTML = data;

        class Reload {
            constructor(html) {
                this.html = html;

                this.loadPageNation();
                this.loadList();
                this.loadUrl();
            }

            loadPageNation() {
                document.querySelector('.pagination').innerHTML = this.html.querySelector('.pagination').innerHTML;
            }

            loadList() {
                document.querySelector('.list > .row').innerHTML = this.html.querySelector('.list > .row').innerHTML;
            }

            loadUrl() {
                history.pushState({}, null, 'board');
            }
        }

        new Reload( html );

        this.init();
    }

    //xml로 페이지 얻어옴
    send(href) {
        return new Promise((resolve, reject) => {
            var xml = new XMLHttpRequest();

            xml.open('GET', href, true); //비동기

            xml.addEventListener("load", () => {
                if (xml.status === 200) {
                    resolve(xml.response);
                }
            });

            xml.send();
        })
    }
}

new App();