'use strict';

class Component{
    constructor(){}

    matchElement(name){
        var key = this.helper.matchElementKey(this.data, name);
        return this.data[key];
    }
    getStatus(name){
        return this.root.all(this.matchElement(name)).map((elem) => {
            return elem.isSelected().then((isSelected) => {
                return (isSelected)? 'Выбрана': 'Не выбрана';
            });
        });
    }
    getElementText(name){
        var txt = this.root.all(this.matchElement(name)).getText();
        return txt;
    }
    isElementDisplayed(name){
        return this.root.element(this.matchElement(name)).isDisplayed();
    }
    isElementOpened(name = 'состояние'){
        return this.root.element(this.matchElement(name)).getAttribute('class').then((attributeValue) => {
            return (attributeValue.indexOf('active') > -1)? true: false;
        });
    }
    clickElement(name = undefined){
        return (name)? this.root.element(this.matchElement(name)).click(): this.root.click();
    }
    enterText(name, text){
        return this.root.element(this.matchElement(name)).sendKeys(text);
    }
}

module.exports = Component;