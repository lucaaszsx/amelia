'use strict';

(function() {
    const buttons = document.querySelectorAll('.row > button');
    const operations = {
        multi: '×', div: '÷', mod: '%',
        add: '+', min: '-', eq: '='
    };
    const state = {
        displayValue: '0',
        clearDisplay: false,
        operation: null,
        values: [ 0, 0 ],
        current: 0
    };
    const handleAction = (target) => {
        switch (target.id) {
            case 'ac': {
                state.displayValue = '0';
                state.clearDisplay = false;
                state.operation = null;
                state.values = [ 0, 0 ];
                state.current = 0;
            break; }
            case 'del': {
                if (state.operation) {
                    state.operation = null;
                    state.current--;
                } else state.displayValue = state.displayValue.slice(0, -1) || '0';
            break; }
            case 'multi':
            case 'div':
            case 'mod':
            case 'add':
            case 'min':
            case 'eq':
                handleOperation(operations[target.id]);
                break;
            default:
                handleDigitAdd(target.innerText);
        }
    };
    const handleOperation = (operation) => {
        if (state.current === 0) {
            state.clearDisplay = true;
            state.operation = operation;
            state.current++;
            
            return;
        }
        
        const equals = operation === '=';
        const values = [ ...state.values ]
            .map((num) => Math.floor(parseFloat(num) * 1e5) / 1e5);
        
        switch (state.operation) {
            case '+':
                values[0] += values[1];
                values[1] = 0;
                break;
            case '-':
                values[0] -= values[1];
                values[1] = 0;
                break;
            case '×':
                values[0] *= values[1];
                values[1] = 0;
                break;
            case '÷':
                values[0] /= values[1];
                values[1] = 0;
                break;
            case '%':
                values[0] %= values[1];
                values[1] = 0;
                break;
        }
        
        state.displayValue = values[0].toString();
        state.clearDisplay = !equals;
        state.operation = equals ? null : operation;
        state.current = equals ? 0 : 1;
        state.values = values;
    };
    const handleDigitAdd = (digit) => {
        const isZeroDigit = digit === '00' || digit === '0';
        
        if ((digit === '.' && state.displayValue.includes('.')) ||
            (parseFloat(state.values[state.current]) === 0 && isZeroDigit) ||
            (state.displayValue.split('.')[1]?.length > 0 && isZeroDigit)) return;
        
        state.displayValue = (state.displayValue === '0' || state.clearDisplay ? '' : state.displayValue) + digit;
        state.clearDisplay = false;
        
        if (digit !== '.') state.values[state.current] = parseFloat(state.displayValue).toFixed(5);
    };
    
    buttons.forEach((button) => {
        button.onclick = (event) => {
            if ('vibrate' in navigator) navigator.vibrate(10);
            
            handleAction(event.target);
            console.log(state);
            
            document.getElementById('operator').value = state.operation || '';
            document.getElementById('result').value = state.displayValue;
        };
    });
})();